package com.patent.patent.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;

@Builder(toBuilder = true)
@Getter(AccessLevel.PRIVATE)
public class Response<T> {
    private T content;
    private HttpStatus statusCode;
    @Nullable
    private String errorMessage; // 성공시에는, 별다른 예외 메시지가 필요없으므로 Nullable하다.
    private boolean success;

    public static <T> Response success(T content, HttpStatus statusCode) {
        return Response
                .builder()
                .content(content)
                .statusCode(statusCode)
                .success(true)
                .build();
    }

    public static <T> Response fail(T content, HttpStatus statusCode, String errorMessage) {
        return Response
                .builder()
                .content(content)
                .statusCode(statusCode)
                .errorMessage(errorMessage)
                .success(false)
                .build();
    }
}
