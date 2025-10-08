package com.example.ticket_rhmed.state;

import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;

public class OpenTicketState extends StatusTicketState {
    @Override
    public void analyze(Ticket ticket) {
        ticket.setStatus(TicketStatus.EM_ANALISE);
        ticket.setStatusTicketState(new InAnalysisTicketState());
    }
}
