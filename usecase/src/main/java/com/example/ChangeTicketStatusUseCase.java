package com.example;

import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;

public interface ChangeTicketStatusUseCase {
    void change(Long ticketId, TicketActionEnum action, User user, String comment) throws Exception;
}
