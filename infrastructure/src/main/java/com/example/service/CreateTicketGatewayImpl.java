package com.example.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.exception.CreateTicketException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.TicketEntity;
import com.example.entity.TicketHistoryEntity;
import com.example.gateway.CreateTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;
import com.example.repository.TicketEntityRepository;
import com.example.repository.TicketHistoryEntityRepository;

@Service
public class CreateTicketGatewayImpl implements CreateTicketGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;
    private final TicketHistoryEntityRepository TicketHistoryEntityRepository;

    public CreateTicketGatewayImpl(
        TicketEntityRepository ticketEntityRepository, 
        TicketMapper ticketMapper, 
        TicketHistoryEntityRepository TicketHistoryEntityRepository,
        UserMapper userMapper
    ) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
        this.TicketHistoryEntityRepository = TicketHistoryEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean create(Ticket ticket) {
        try {
            var ticketEntity = ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
            registryAssist(ticketEntity);
        } catch (Exception e) {
            throw new CreateTicketException(ErrorCodeEnum.TKT001.getMessage() + ": " + e.getMessage(), ErrorCodeEnum.TKT001.getCode());
        }
        return true;
    }

    private void registryAssist(TicketEntity ticket) {

        TicketHistoryEntity ticketHistoryEntity = new TicketHistoryEntity();
        ticketHistoryEntity.setTicket(ticket);
        ticketHistoryEntity.setStatus(ticket.getStatus());
        ticketHistoryEntity.setUser(ticket.getRequester());
        ticketHistoryEntity.setComment("Ticket criado pelo usuário");
        ticketHistoryEntity.setCreatedAt(LocalDate.now());
        ticketHistoryEntity.setUpdatedAt(LocalDate.now());
        
        TicketHistoryEntityRepository.save(ticketHistoryEntity);
    }
    
}
