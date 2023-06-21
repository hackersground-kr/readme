package com.alt.readmeuserservice.filter;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.response.ExceptionResponseEntity;
import com.alt.readmeuserservice.domain.response.Result;
import com.alt.readmeuserservice.domain.user.LoginRequest;
import com.alt.readmeuserservice.domain.user.UserForSecurity;
import com.alt.readmeuserservice.exception.CustomAuthenticationException;
import com.alt.readmeuserservice.exception.GlobalException;
import com.alt.readmeuserservice.service.impl.RefreshTokenServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Log4j2
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public JwtAuthenticationFilter(
            AuthenticationManagerBuilder authenticationManagerBuilder,
            JwtTokenProvider jwtTokenProvider,
            RefreshTokenServiceImpl refreshTokenServiceImpl,
            CookieProvider cookieProvider
    ) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenServiceImpl = refreshTokenServiceImpl;
        this.cookieProvider = cookieProvider;

        setFilterProcessesUrl("/login.do");
    }
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenServiceImpl refreshTokenServiceImpl;
    private final CookieProvider cookieProvider;

    // login 리퀘스트 패스로 오는 요청을 판단
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        Authentication authentication;
        try {
            LoginRequest credential = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

            authentication = authenticationManagerBuilder.getObject().authenticate(
                    new UsernamePasswordAuthenticationToken(credential.getEmail(), credential.getPassword())
            );
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (GlobalException e) {
            throw new CustomAuthenticationException(e.getMessage());
        }
    }

    // 로그인 성공 이후 토큰 생성
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        UserForSecurity user = (UserForSecurity) authResult.getPrincipal();

        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String userId = user.getUsername();
        String refreshUUID = UUID.randomUUID().toString();

        // response body에 넣어줄 access token 및 expired time 생성
        String accessToken = jwtTokenProvider.generateAccessToken(userId, request.getRequestURI(), roles);
        String refreshToken = jwtTokenProvider.generateRefreshToken(refreshUUID);

        // redis에 새로 발행된 refresh token 값 추가
        refreshTokenServiceImpl.createRefreshToken(userId, jwtTokenProvider.getTokenId(refreshToken));

        // 쿠키 설정
        ResponseCookie refreshTokenCookie = cookieProvider.createRefreshTokenCookie(refreshToken);
        ResponseCookie accessTokenCookie = cookieProvider.createAccessTokenCookie(accessToken);

        Cookie refCookie = cookieProvider.of(refreshTokenCookie);
        Cookie accCookie = cookieProvider.of(accessTokenCookie);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.addCookie(refCookie);
        response.addCookie(accCookie);

        new ObjectMapper().writeValue(response.getOutputStream(), Result.createSuccessResult("login success"));
    }
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(APPLICATION_JSON_VALUE);
        ExceptionResponseEntity exception = ExceptionResponseEntity.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(failed.getMessage())
                .error(HttpStatus.FORBIDDEN)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(exception));
    }
    @Override
    public void setFilterProcessesUrl(String filterProcessesUrl) {
        super.setFilterProcessesUrl(filterProcessesUrl);
    }
}