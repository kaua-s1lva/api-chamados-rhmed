package com.example.ticket_rhmed.state;

import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;

public class InDevelopmentTicketState extends StatusTicketState {
    @Override
    public void validate(Ticket ticket) {
        ticket.setStatus(TicketStatus.AGUARDANDO_APROVACAO);
        ticket.setStatusTicketState(new WaitingApprovalTicketState());
    }
    
}
