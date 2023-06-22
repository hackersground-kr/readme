package com.alt.readmeuserservice.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
public class TokenInfo {
    public TokenInfo() {

    }
    private String access;
    private String refresh;
}
