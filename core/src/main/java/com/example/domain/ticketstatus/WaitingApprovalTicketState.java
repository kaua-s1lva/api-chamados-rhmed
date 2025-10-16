package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class WaitingApprovalTicketState extends TicketStatusState {

    public WaitingApprovalTicketState(Ticket ticket) {
        super(ticket);
    }

    @Override
    public void approveValidation() {
        ticket.changeState(new CompleteTicketState(ticket));
    }

    @Override
    public void rejectValidation() {
        ticket.changeState(new CanceledTicketState(ticket));
    }

    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.AGUARDANDO_APROVACAO;
    }
    
}
