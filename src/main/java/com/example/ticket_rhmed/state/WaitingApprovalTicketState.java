package com.example.ticket_rhmed.state;

import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;

public class WaitingApprovalTicketState extends StatusTicketState {
    @Override
    public void approveValidation(Ticket ticket) {
        ticket.setStatus(TicketStatus.CONCLUIDO);
        ticket.setStatusTicketState(new CompleteTicketState());
    }
    
}
