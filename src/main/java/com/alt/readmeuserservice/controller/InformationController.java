package com.alt.readmeuserservice.controller;

import com.alt.readmeuserservice.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/info")
@RequiredArgsConstructor
public class InformationController {
    final private Environment environment;
    @GetMapping("/health_check")
    public String healthCheck() {
        return "Send To localhost:" + environment.getProperty("local.server.port");
    }
    @GetMapping("/throw")
    public String throwError() {
        throw new GlobalException(HttpStatus.BAD_REQUEST, "throw");
    }
}