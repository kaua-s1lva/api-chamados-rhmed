package com.example.usecaseimpl;

import com.example.UpdateTicketUseCase;
import com.example.domain.Ticket;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.domain.ticketstatus.TicketStatusState;
import com.example.gateway.ChangeTicketStatusGateway;

public class ChangeTicketStatusUseCaseImpl implements UpdateTicketUseCase {
    private ChangeTicketStatusGateway changeTicketStatusGateway;

    public ChangeTicketStatusUseCaseImpl(ChangeTicketStatusGateway changeTicketStatusGateway) {
        this.changeTicketStatusGateway = changeTicketStatusGateway;
    }

    @Override
    public void change(Ticket ticket, TicketStatusState state) throws ChangeStateException {
        if (!changeTicketStatusGateway.change(ticket, state)) {
            throw new ChangeStateException(ErrorCodeEnum.TKT002.getMessage(), ErrorCodeEnum.TKT002.getCode());
        }
    }
}
