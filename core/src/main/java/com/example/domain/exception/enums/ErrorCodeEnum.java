package com.example.domain.exception.enums;

public enum ErrorCodeEnum {
    USR001("Email indisponível", "USR001"),
    USR002("Houve um erro ao criar o usuário", "USR002"),

    ATH001("Houve um erro na autenticação", "ATH001"),

    TKT001("Houve um erro ao criar o ticket", "TKT001"),
    TKT002("Houve um erro ao atualizar o ticket", "TKT002")
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
