package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.Purpose;
import com.alt.readsearchservice.domain.response.ResponseEntity;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purpose")
@RequiredArgsConstructor
public class PurposeSearchController {
    private final SearchService searchService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Purpose purpose) {
        searchService.purposeRegister(purpose);
        return ResponseEntity.builder()
                .data("success")
                .build();
    }
    @GetMapping("/student")
    public ResponseEntity getEnterpriseByPurpose(@RequestParam String email) {
        return ResponseEntity.builder()
                .data(searchService.getPurposeByStudent(email))
                .build();
    }
    @GetMapping("/enterprise")
    public ResponseEntity getStudentByPurpose(@RequestParam String email) {
        return ResponseEntity.builder()
                .data(searchService.getPurposeByEnterprise(email))
                .build();
    }

}