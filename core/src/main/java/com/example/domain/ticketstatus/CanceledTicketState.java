package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class CanceledTicketState extends TicketStatusState{
    public CanceledTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void complete() {
        ticket.changeState(new CompleteTicketState(ticket));
    }

    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.CANCELADO;
    }
}
