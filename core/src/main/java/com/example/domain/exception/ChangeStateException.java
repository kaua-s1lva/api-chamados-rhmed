package com.example.domain.exception;

public class ChangeStateException extends Exception {
    private String code;

    public ChangeStateException(String message, String code) {
        super(message);
        this.code = code;
    }
}
