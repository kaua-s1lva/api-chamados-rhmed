package com.example.usecaseimpl;

import com.example.CreateTicketUseCase;
import com.example.domain.Ticket;
import com.example.domain.exception.InternalServerErrorException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.CreateTicketGateway;

public class CreateTicketUseCaseImpl implements CreateTicketUseCase {
    private CreateTicketGateway createTicketGateway;

    public CreateTicketUseCaseImpl(CreateTicketGateway createTicketGateway) {
        this.createTicketGateway = createTicketGateway;
    }

    @Override
    public void create(Ticket ticket) throws InternalServerErrorException {
        if (!createTicketGateway.create(ticket)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TKT001.getMessage(), ErrorCodeEnum.TKT001.getCode());
        }
        createTicketGateway.create(ticket);
    }
}
