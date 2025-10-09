package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.gateway.CreateTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class CreateTicketGatewayImpl implements CreateTicketGateway {
    private TicketEntityRepository ticketEntityRepository;
    private TicketMapper ticketMapper;

    public CreateTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public Boolean create(Ticket ticket) {
        try {
            ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
