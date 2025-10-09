package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class InAnalysisTicketState extends TicketStatusState {
    public InAnalysisTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void requestInformation() {
        ticket.changeState(new RequestedInformationTicketState(ticket));
    }

    @Override
    public void approveAnalysis() {
        ticket.changeState(new ApprovedAnalysisTicketState(ticket));
    }

    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.EM_ANALISE;
    }
    
}
