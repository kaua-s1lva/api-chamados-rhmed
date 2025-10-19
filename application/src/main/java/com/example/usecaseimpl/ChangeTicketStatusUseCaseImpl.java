package com.example.usecaseimpl;

import com.example.ChangeTicketStatusUseCase;
import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;
import com.example.domain.exception.ChangeStateException;
import com.example.gateway.ChangeTicketStatusGateway;

public class ChangeTicketStatusUseCaseImpl implements ChangeTicketStatusUseCase {
    private ChangeTicketStatusGateway changeTicketStatusGateway;

    public ChangeTicketStatusUseCaseImpl(ChangeTicketStatusGateway changeTicketStatusGateway) {
        this.changeTicketStatusGateway = changeTicketStatusGateway;
    }

    @Override
    public void change(Long ticketId, TicketActionEnum action, User user, String comment) throws ChangeStateException {
        changeTicketStatusGateway.change(ticketId, action, user, comment);
    }
}
