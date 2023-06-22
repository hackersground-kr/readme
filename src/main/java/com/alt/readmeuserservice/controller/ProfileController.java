package com.alt.readmeuserservice.controller;

import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.response.ResponseEntity;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;
    @GetMapping("/get")
    public ResponseEntity search(@RequestHeader("Authorization") String access) {

        return ResponseEntity.builder()
                .data(userMapper.getByEmail(jwtTokenProvider.getUserId(access)))
                .build();
    }
}
