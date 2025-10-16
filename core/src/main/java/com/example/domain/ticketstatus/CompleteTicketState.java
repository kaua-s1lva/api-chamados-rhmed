package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class CompleteTicketState extends TicketStatusState {

    public CompleteTicketState(Ticket ticket){
        super(ticket);
    }

    @Override
    public TicketStatusEnum getStatus() {
        return TicketStatusEnum.CONCLUIDO;
    }
    
}
