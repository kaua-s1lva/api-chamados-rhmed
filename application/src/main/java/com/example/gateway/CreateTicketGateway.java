package com.example.gateway;

import com.example.domain.Ticket;

public interface CreateTicketGateway {
    Boolean create(Ticket ticket);
}
