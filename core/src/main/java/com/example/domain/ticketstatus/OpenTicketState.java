package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class OpenTicketState extends TicketStatusState {
    public OpenTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void analyze() {
        ticket.changeState(new InAnalysisTicketState(ticket));
    }

    @Override
    public void cancel() {
        ticket.changeState(new CanceledTicketState(ticket));
    }
    
    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.ABERTO;
    }
}
