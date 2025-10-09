package com.example.gateway;

import com.example.domain.Ticket;
import com.example.domain.ticketstatus.TicketStatusState;

public interface ChangeTicketStatusGateway {
    Boolean change(Ticket ticket, TicketStatusState state);
}
