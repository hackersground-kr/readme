package com.alt.readmeuserservice.exception;

import com.alt.readmeuserservice.domain.response.ExceptionResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class  ExceptionAdvice {
    @ExceptionHandler(GlobalException.class)
    protected ResponseEntity<ExceptionResponseEntity> GlobalException(GlobalException e){
        ExceptionResponseEntity responseDto = ExceptionResponseEntity.builder()
                .message(e.getMessage())
                .status(e.getHttpStatus().value())
                .error(e.getHttpStatus())
                .build();
        return ResponseEntity.status(e.getHttpStatus())
                .body(responseDto);
    }
}