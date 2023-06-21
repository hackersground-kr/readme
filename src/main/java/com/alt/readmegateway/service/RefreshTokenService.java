package com.alt.readmegateway.service;

import com.alt.readmegateway.entity.TokenInfo;

public interface RefreshTokenService {
    public void createRefreshToken(String email, String uuid);
    public TokenInfo refresh(String uuid);
}