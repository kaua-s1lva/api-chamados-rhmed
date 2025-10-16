package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class InDevelopmentTicketState extends TicketStatusState {

    public InDevelopmentTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void validate() {
        ticket.changeState(new WaitingApprovalTicketState(ticket));
    }
    
    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.EM_DESENVOLVIMENTO;
    }
}
