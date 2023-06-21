package com.alt.readmegateway.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 반환 객체
 */
@Data
@SuperBuilder
public class ResponseEntity {
    protected int status;
    protected Object data;
}