package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public abstract class TicketStatusState {
    protected Ticket ticket;
    
    public TicketStatusState(Ticket ticket) {
        this.ticket = ticket;
    }

    abstract public TicketStatusEnum getStatus();
    
    public void analyze() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void requestInformation() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void approveAnalysis() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void validate() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void approveValidation() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void rejectValidation() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void cancel() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }

    public void complete() {
        throw new RuntimeException("Não é possível realizar essa ação no estado atual");
    }
}
