package com.example.domain.exception.enums;

public enum ErrorCodeEnum {
    USR001("Email indisponível", "USR001"),
    USR002("Houve um erro ao criar o usuário", "USR002"),

    ATH001("Houve um erro na autenticação", "ATH001")
    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
