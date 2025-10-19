package com.example;

import com.example.domain.Ticket;
import com.example.domain.exception.TicketException;

public interface UpdateTicketUseCase {
    void update(Ticket ticket) throws TicketException;
}
