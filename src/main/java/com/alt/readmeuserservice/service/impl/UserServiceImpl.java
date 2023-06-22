package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.request.TokenInfo;
import com.alt.readmeuserservice.domain.user.*;
import com.alt.readmeuserservice.exception.GlobalException;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.RefreshTokenService;
import com.alt.readmeuserservice.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final CookieProvider cookieProvider;

    @Override
    @Transactional
    public User signUpStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        userMapper.register(student);
        userMapper.registerStudent(student);

        return student;
    }
    @Override
    @Transactional
    public User signUpSchool(School school) {
        school.setPassword(passwordEncoder.encode(school.getPassword()));
        userMapper.register(school);
        userMapper.registerSchool(school);

        return school;
    }
    @Override
    @Transactional
    public User signUpEnterprise(Enterprise enterprise) {
        enterprise.setPassword(passwordEncoder.encode(enterprise.getPassword()));
        userMapper.register(enterprise);
        userMapper.registerEnterprise(enterprise);

        return enterprise;
    }
    @Override
    public TokenInfo login(LoginRequest request) {
        User user = userMapper.getByEmail(request.getEmail());
        if(user == null) throw new GlobalException(HttpStatus.UNAUTHORIZED, "user not found");
        if(passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            TokenInfo tokenInfo = TokenInfo.builder().build();
            UserForSecurity security = UserForSecurity.builder().user(user).build();
            List<String> roles = security.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            tokenInfo.setAccess(jwtTokenProvider.generateAccessToken(user.getEmail(), roles));
            String refreshUUID = UUID.randomUUID().toString();
            tokenInfo.setRefresh(jwtTokenProvider.generateRefreshToken(refreshUUID));
            refreshTokenService.createRefreshToken(user.getEmail(), jwtTokenProvider.getTokenId(tokenInfo.getRefresh()));

            return tokenInfo;
        } else {
            throw new GlobalException(HttpStatus.UNAUTHORIZED, "password not match");
        }
    }

    @Override
    public void logout(HttpServletResponse response) {
        Cookie access = cookieProvider.of(cookieProvider.removeAccessTokenCookie());
        Cookie refresh = cookieProvider.of(cookieProvider.removeRefreshTokenCookie());

        response.addCookie(access);
        response.addCookie(refresh);
    }
}
