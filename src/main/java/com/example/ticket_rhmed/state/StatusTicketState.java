package com.example.ticket_rhmed.state;

import com.example.ticket_rhmed.models.Ticket;

public abstract class StatusTicketState {
    public void analyze(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void requestInformation(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void approveAnalysis(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void validate(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void approveValidation(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void rejectValidation(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void cancel(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void complete(Ticket ticket) {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

}
