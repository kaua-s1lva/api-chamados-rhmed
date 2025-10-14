package com.example.service;

import com.example.domain.Ticket;
import com.example.domain.ticketstatus.TicketStatusState;
import com.example.gateway.ChangeTicketStatusGateway;

public class ChangeTicketStatusGatewayImpl implements ChangeTicketStatusGateway {

    @Override
    public Boolean change(Ticket ticket, TicketStatusState state) {
        
        return true;
    }

}
