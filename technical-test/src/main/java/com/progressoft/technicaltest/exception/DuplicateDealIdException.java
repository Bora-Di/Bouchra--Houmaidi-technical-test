package com.progressoft.technicaltest.exception;

public class DuplicateDealIdException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateDealIdException(String message) {
        super(message);
    }

    public DuplicateDealIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateDealIdException(Throwable cause) {
        super(cause);
    }
}