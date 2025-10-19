package com.example.domain.exception;

public class TicketException extends RuntimeException{
    private final String code;

    public TicketException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
