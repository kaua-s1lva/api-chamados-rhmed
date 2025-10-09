package com.example;

import com.example.domain.Ticket;
import com.example.domain.exception.InternalServerErrorException;

public interface CreateTicketUseCase {
    void create(Ticket ticket) throws InternalServerErrorException;
}
