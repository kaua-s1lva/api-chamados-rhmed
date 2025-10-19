package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.gateway.UpdateTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class UpdateTicketGatewayImpl implements UpdateTicketGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;

    public UpdateTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public Boolean update(Ticket ticket) {
        ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
        return true;
    }

}
