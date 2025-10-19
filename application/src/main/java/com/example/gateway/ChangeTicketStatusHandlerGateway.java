package com.example.gateway;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.exception.ChangeStateException;

public interface ChangeTicketStatusHandlerGateway {
    void changeStatus(Ticket ticket, User user, String comment) throws ChangeStateException;
}
