package com.example;

import com.example.domain.Ticket;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.ticketstatus.TicketStatusState;

public interface UpdateTicketUseCase {
    void change(Ticket ticket, TicketStatusState state) throws ChangeStateException;
}
