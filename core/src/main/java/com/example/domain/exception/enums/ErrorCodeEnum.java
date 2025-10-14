package com.example.domain.exception.enums;

public enum ErrorCodeEnum {
    USR001("Email indisponível", "USR001"),
    USR002("Houve um erro ao criar o usuário", "USR002"),
    USR003("Usuário não encontrado", "USR003"),
    USR004("Senha incorreta", "USR004"),

    ATH001("Houve um erro na autenticação", "ATH001"),

    TKT001("Houve um erro ao criar o ticket", "TKT001"),
    TKT002("Houve um erro ao atualizar o ticket", "TKT002"),
    TKT003("Ticket não encontrado", "TKT003"),
    TKT004("Houve um erro ao analisar o ticket", "TKT004"),
    TKT005("Ticket não corresponde ao usuário logado", "TKT005")
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
