package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.domain.user.Enterprise;
import com.alt.readmeuserservice.domain.user.School;
import com.alt.readmeuserservice.domain.user.Student;
import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
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
    public void logout(HttpServletResponse response) {
        Cookie access = cookieProvider.of(cookieProvider.removeAccessTokenCookie());
        Cookie refresh = cookieProvider.of(cookieProvider.removeRefreshTokenCookie());

        response.addCookie(access);
        response.addCookie(refresh);
    }
}
