package com.example;

import com.example.domain.enums.TicketActionEnum;

public interface ChangeTicketStatusUseCase {
    void change(Long ticketId, TicketActionEnum action, String comment) throws Exception;
}
