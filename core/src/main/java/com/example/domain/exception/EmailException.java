package com.example.domain.exception;

public class EmailException extends Exception{
    private final String code;

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
