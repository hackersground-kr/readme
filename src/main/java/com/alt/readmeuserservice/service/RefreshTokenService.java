package com.alt.readmeuserservice.service;


public interface RefreshTokenService {
    public void createRefreshToken(String email, String uuid);
}