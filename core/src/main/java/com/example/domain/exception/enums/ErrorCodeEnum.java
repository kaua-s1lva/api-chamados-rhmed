package com.example.domain.exception.enums;

public enum ErrorCodeEnum {
    USR001("Email indisponível", "USR001"),
    USR002("Houve um erro ao criar o usuário", "USR002"),
    USR003("Usuário ou senha inválidos", "USR003"),

    ATH001("Usuário não encontrado", "ATH001"),
    ATH002("Senha inválida", "ATH002"),
    ATH003("Token inválido", "ATH003"),
    ATH004("Token expirado", "ATH004"),

    TKT001("Houve um erro ao criar o ticket", "TKT001"),
    TKT002("Houve um erro ao atualizar o ticket", "TKT002"),
    TKT003("Ticket não encontrado", "TKT003"),
    TKT005("Ticket não corresponde ao usuário logado", "TKT005"),
    TKT006("Mudança de status não permitida", "TKT006"),

    GEN001("Recurso não encontrado", "GEN001"),
    GEN002("Erro de validação", "GEN002"),
    GEN003("Método não permitido", "GEN003"),
    GEN004("Erro interno do servidor", "GEN004"),
    GEN005("Acesso negado", "GEN005")
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
