package com.example.domain.exception;

public class CreateTicketException extends RuntimeException{
    private final String code;

    public CreateTicketException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
