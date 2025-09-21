package com.example.ticket_rhmed.models;

public enum TicketStatus {
    
    ABERTO("aberto"),
    EM_ANDAMENTO("em_andamento"),
    ENCERRADO("encerrado");

    private final String status;

    private TicketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
