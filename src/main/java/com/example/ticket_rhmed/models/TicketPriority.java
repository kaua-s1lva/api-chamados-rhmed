package com.example.ticket_rhmed.models;

public enum TicketPriority {
    
    BAIXA("baixa"),
    MEDIA("media"),
    ALTA("alta");

    private final String priority;

    private TicketPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
