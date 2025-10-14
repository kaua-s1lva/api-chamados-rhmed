package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.exception.InternalServerErrorException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.AnalyzeTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class AnalyzeTicketGatewayImpl implements AnalyzeTicketGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;

    public AnalyzeTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public Boolean analyze(Long ticketId, User user) throws Exception {
        Ticket ticket = ticketMapper.toTicket(ticketEntityRepository.findById(ticketId).orElseThrow(
            () -> new InternalServerErrorException(ErrorCodeEnum.TKT003.getMessage(), ErrorCodeEnum.TKT003.getCode())
        ));
        if (!ticket.getRequester().equals(user)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TKT005.getMessage(), ErrorCodeEnum.TKT005.getCode());
        }
        ticket.analyze();
        ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
        return true;
    }
}
