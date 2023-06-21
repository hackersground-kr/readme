package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final CookieProvider cookieProvider;

    @Override
    public User signUp(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userMapper.register(user);
        return user;
    }
    @Override
    public void logout(HttpServletResponse response) {
        Cookie access = cookieProvider.of(cookieProvider.removeAccessTokenCookie());
        Cookie refresh = cookieProvider.of(cookieProvider.removeRefreshTokenCookie());

        response.addCookie(access);
        response.addCookie(refresh);
    }
}
