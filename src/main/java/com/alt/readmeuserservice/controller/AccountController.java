package com.alt.readmeuserservice.controller;

import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.request.TokenInfo;
import com.alt.readmeuserservice.domain.response.ResponseEntity;
import com.alt.readmeuserservice.domain.response.Result;
import com.alt.readmeuserservice.domain.user.*;
import com.alt.readmeuserservice.service.RefreshTokenService;
import com.alt.readmeuserservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;
    private final RefreshTokenService refreshTokenService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    @PostMapping("/signup/student")
    public ResponseEntity registerStudent(@RequestBody Student student) {
        student.setType('S');
        return ResponseEntity.builder()
                .status(200)
                .data(userService.signUpStudent(student))
                .build();
    }
    @PostMapping("/signup/enterprise")
    public ResponseEntity registerEnterprise(@RequestBody Enterprise enterprise) {
        enterprise.setType('E');
        return ResponseEntity.builder()
                .status(200)
                .data(userService.signUpEnterprise(enterprise))
                .build();
    }
    @PostMapping("/signup/school")
    public ResponseEntity registerSchool(@RequestBody School school) {
        school.setType('A');
        return ResponseEntity.builder()
                .status(200)
                .data(userService.signUpSchool(school))
                .build();
    }
    @GetMapping("/refresh")
    public org.springframework.http.ResponseEntity<?> refresh(@CookieValue("refresh-token") String refresh) {

        return refreshTokenService.refresh(jwtTokenProvider.getTokenId(refresh));
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest credential) {
        Authentication authentication;
        authentication = authenticationManagerBuilder.getObject().authenticate(
                new UsernamePasswordAuthenticationToken(credential.getEmail(), credential.getPassword())
        );

        UserForSecurity user = (UserForSecurity) authentication.getPrincipal();

        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String userId = user.getUsername();
        String refreshUUID = UUID.randomUUID().toString();

        // response body에 넣어줄 access token 및 expired time 생성
        String accessToken = jwtTokenProvider.generateAccessToken(userId, roles);
        String refreshToken = jwtTokenProvider.generateRefreshToken(refreshUUID);

        // redis에 새로 발행된 refresh token 값 추가
        refreshTokenService.createRefreshToken(userId, jwtTokenProvider.getTokenId(refreshToken));

        return ResponseEntity.builder()
                .data(TokenInfo.builder()
                        .access(accessToken)
                        .refresh(refreshToken)
                        .build())
                .build();
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response) {
        userService.logout(response);
        return ResponseEntity.builder()
                .status(200)
                .data("logout success")
                .build();
    }
}