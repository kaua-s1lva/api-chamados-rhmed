package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class RequestedInformationTicketState extends TicketStatusState{
    public RequestedInformationTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void analyze() {
        ticket.changeState(new InAnalysisTicketState(ticket));
    }

    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.AGUARDANDO_INFORMACOES;
    }
    
}
