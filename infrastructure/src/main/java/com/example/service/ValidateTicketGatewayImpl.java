package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.ChangeTicketStatusGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class ValidateTicketGatewayImpl implements ChangeTicketStatusGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;

    public ValidateTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public void change(Long ticketId, TicketActionEnum action, User user, String comment) throws ChangeStateException {
        Ticket ticket = ticketMapper.toTicket(ticketEntityRepository.findById(ticketId).orElseThrow(
            () -> new ChangeStateException(ErrorCodeEnum.TKT003.getMessage(), ErrorCodeEnum.TKT003.getCode())
        ));
        if (!ticket.getRequester().equals(user)) {
            throw new ChangeStateException(ErrorCodeEnum.TKT005.getMessage(), ErrorCodeEnum.TKT005.getCode());
        }
        ticket.validate();
        ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
    }
}
