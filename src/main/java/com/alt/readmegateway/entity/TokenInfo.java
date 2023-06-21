package com.alt.readmegateway.entity;

import lombok.Builder;
import lombok.Data;

/**
 * jwt 토큰
 */
@Data
@Builder
public class TokenInfo {
    private String access;
    private String refresh;
}
