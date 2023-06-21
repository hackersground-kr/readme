package com.alt.readmeuserservice.domain.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
public class ExceptionResponseEntity extends ResponseEntity {
    private HttpStatus error;
    private String message;
}
