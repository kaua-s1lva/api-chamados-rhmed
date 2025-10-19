package com.example.gateway;

import com.example.domain.enums.TicketActionEnum;
import com.example.domain.exception.ChangeStateException;

public interface ChangeTicketStatusGateway {
    void change(Long ticketId, TicketActionEnum action, String comment) throws ChangeStateException;
}
