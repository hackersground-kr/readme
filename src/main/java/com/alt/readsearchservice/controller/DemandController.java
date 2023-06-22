package com.alt.readsearchservice.controller;

import com.alt.readsearchservice.domain.Demand;
import com.alt.readsearchservice.domain.Purpose;
import com.alt.readsearchservice.domain.response.ResponseEntity;
import com.alt.readsearchservice.domain.user.User;
import com.alt.readsearchservice.mapper.DemandMapper;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demand")
@RequiredArgsConstructor
public class DemandController {
    private final SearchService searchService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("email") String email, @RequestParam("name") String lineName) {
        searchService.getEnterpriseByEmail(email);
        searchService.demandRegister(email, lineName);
        return ResponseEntity.builder()
                .data("success")
                .build();
    }
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String lineName) {
        return ResponseEntity.builder()
                .data(searchService.demandSearch(lineName))
                .build();
    }
}
