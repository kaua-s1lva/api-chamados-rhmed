package com.example.service.tickethandler;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.ChangeTicketStatusHandlerGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class CompleteTicketGatewayImpl implements ChangeTicketStatusHandlerGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;

    public CompleteTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public void changeStatus(Ticket ticket, User user, String comment) throws ChangeStateException {
        if (!ticket.getRequester().equals(user)) {
            throw new ChangeStateException(ErrorCodeEnum.TKT005.getMessage(), ErrorCodeEnum.TKT005.getCode());
        }
        ticket.complete();
        ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
    }
}
