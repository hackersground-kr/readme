package com.alt.readmeuserservice.service;


import org.springframework.http.ResponseEntity;

public interface RefreshTokenService {
    public void createRefreshToken(String email, String uuid);
    public ResponseEntity<?> refresh(String uuid);
}