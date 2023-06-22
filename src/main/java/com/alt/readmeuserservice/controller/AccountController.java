package com.alt.readmeuserservice.controller;

import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.response.ResponseEntity;
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
    @PostMapping("/signup.do")
    public ResponseEntity register(@RequestBody User user) {
        return ResponseEntity.builder()
                .status(200)
                .data(userService.signUp(user))
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