package com.example.domain.exception;

public class CreateUserException extends RuntimeException {
    private final String code;

    public CreateUserException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
