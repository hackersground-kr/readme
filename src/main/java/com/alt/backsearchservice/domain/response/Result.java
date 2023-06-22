package com.alt.backsearchservice.domain.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {
    private StatusCode code;
    private String message;
    private T data;

    @Builder
    public Result(StatusCode code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result createErrorResult(String message) {
        return Result.builder()
                .code(StatusCode.ERROR)
                .message(message)
                .build();
    }

    // 해당 <T> 는 클래스의 T와 다름
    public static <T> Result createSuccessResult(String message) {
        return Result.builder()
                .code(StatusCode.SUCCESS)
                .message(message)
                .build();
    }
}