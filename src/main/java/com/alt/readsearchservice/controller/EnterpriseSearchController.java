package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.response.ResponseEntity;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
public class EnterpriseSearchController {
    private final SearchService searchService;
    @GetMapping("/email")
    public ResponseEntity getEnterpriseByEmail(@RequestParam String email) {
        return ResponseEntity.builder()
                .data(searchService.getEnterpriseByEmail(email))
                .build();
    }
    @GetMapping("/name")
    public ResponseEntity getEnterpriseByName(@RequestParam String name) {
        return ResponseEntity.builder()
                .data(searchService.getEnterpriseByName(name))
                .build();
    }

}