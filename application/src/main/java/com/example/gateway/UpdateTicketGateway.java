package com.example.gateway;

import com.example.domain.Ticket;

public interface UpdateTicketGateway {
    Boolean update(Long ticketId, Ticket ticket);
}
