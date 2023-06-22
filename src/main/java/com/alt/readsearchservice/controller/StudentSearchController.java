package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.response.ResponseEntity;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentSearchController {
    private final SearchService searchService;
    @GetMapping("/")
    public ResponseEntity getStudentByEmail(@RequestParam String email) {
        return ResponseEntity.builder()
                .data(searchService.getStudentByEmail(email))
                .build();
    }
    @GetMapping("/name")
    public ResponseEntity getStudentByName(@RequestParam String name) {
        return ResponseEntity.builder()
                .data(searchService.getStudentByName(name))
                .build();
    }

}