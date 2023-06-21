package com.alt.readmegateway.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

/**
 * 예외 반환
 */
@Data
@SuperBuilder
public class ExceptionResponseEntity extends ResponseEntity {
    private HttpStatus error;
    private String message;
}
