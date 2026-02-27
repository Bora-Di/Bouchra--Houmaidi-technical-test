package com.progressoft.technicaltest.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorResponse(
        int code,
        
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime timestamp,
        
        String message,
        
        String description,
        
        Object errors
) {

    // Convenience factory method
    public static ErrorResponse of(int code, String message, String description) {
        return new ErrorResponse(code, LocalDateTime.now(), message, description, null);
    }

    public static ErrorResponse of(int code, String message, String description, Object errors) {
        return new ErrorResponse(code, LocalDateTime.now(), message, description, errors);
    }
}