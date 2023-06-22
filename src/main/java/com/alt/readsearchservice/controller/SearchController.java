package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.response.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SearchController {
    @GetMapping("/user")
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        return ResponseEntity.builder()

                .build();
    }
}