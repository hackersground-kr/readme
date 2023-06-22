package com.alt.readmeuserservice.controller;

import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.response.ResponseEntity;
import com.alt.readmeuserservice.domain.user.Enterprise;
import com.alt.readmeuserservice.domain.user.School;
import com.alt.readmeuserservice.domain.user.Student;
import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.service.RefreshTokenService;
import com.alt.readmeuserservice.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;
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
    @PostMapping("/signup/School")
    public ResponseEntity registerSchool(@RequestBody School school) {
        school.setType('A');
        return ResponseEntity.builder()
                .status(200)
                .data(userService.signUpSchool(school))
                .build();
    }
    @GetMapping("/logout.do")
    public ResponseEntity logout(HttpServletResponse response) {
        userService.logout(response);
        return ResponseEntity.builder()
                .status(200)
                .data("logout success")
                .build();
    }
}