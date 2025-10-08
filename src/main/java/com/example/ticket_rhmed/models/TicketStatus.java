package com.example.ticket_rhmed.models;

public enum TicketStatus {
    
    ABERTO("aberto"),
    EM_ANALISE("em_analise"),
    AGUARDANDO_INFORMACOES("aguardando_informacoes"),
    EM_DESENVOLVIMENTO("em_desenvolvimento"),
    AGUARDANDO_APROVACAO("aguardando_aprovacao"),
    CONCLUIDO("concluido"),
    CANCELADO("cancelado");

    private final String status;

    private TicketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
