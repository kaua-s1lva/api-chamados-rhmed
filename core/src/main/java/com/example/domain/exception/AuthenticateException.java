package com.example.domain.exception;

public class AuthenticateException extends RuntimeException{

    private final String code;

    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}