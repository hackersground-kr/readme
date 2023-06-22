package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.response.ResponseEntity;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SchoolSearchController {
    private final SearchService searchService;
    @GetMapping("/school")
    public ResponseEntity getSchoolByEmail(@RequestParam String email) {
        return ResponseEntity.builder()
                .data(searchService.getSchoolByEmail(email))
                .build();
    }
    @GetMapping("/school/name")
    public ResponseEntity getSchoolByName(@RequestParam String name) {
        return ResponseEntity.builder()
                .data(searchService.getSchoolByName(name))
                .build();
    }

}