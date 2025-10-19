package com.example.usecaseimpl;

import com.example.UpdateTicketUseCase;
import com.example.domain.Ticket;
import com.example.domain.exception.TicketException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.UpdateTicketGateway;

public class UpdateTicketUseCaseImpl implements UpdateTicketUseCase {
    private UpdateTicketGateway updateTicketGateway;

    public UpdateTicketUseCaseImpl(UpdateTicketGateway updateTicketGateway) {
        this.updateTicketGateway = updateTicketGateway;
    }

    @Override
    public void update(Ticket ticket) throws TicketException {
        if (!updateTicketGateway.update(ticket)) {
            throw new TicketException(ErrorCodeEnum.TKT002.getMessage(), ErrorCodeEnum.TKT002.getCode());
        }
    }
}
