package com.example.ticket_rhmed.state;

import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;

public class InAnalysisTicketState extends StatusTicketState {
    @Override
    public void requestInformation(Ticket ticket) {
        ticket.setStatus(TicketStatus.AGUARDANDO_INFORMACOES);
        ticket.setStatusTicketState(new WaitingInformationTicketState());
    }
    
    @Override
    public void approveAnalysis(Ticket ticket) {
        ticket.setStatus(TicketStatus.EM_DESENVOLVIMENTO);
        ticket.setStatusTicketState(new InDevelopmentTicketState());
    }
}
