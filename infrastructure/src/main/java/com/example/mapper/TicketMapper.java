package com.example.mapper;

import com.example.domain.Ticket;
import com.example.dto.request.CreateTicketRequest;
import com.example.entity.TicketEntity;

public class TicketMapper {
    private final UserMapper userMapper;

    public TicketMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public TicketEntity toTicketEntity(Ticket ticket) {
        return new TicketEntity(
            ticket.getId(),
            ticket.getCode(),
            ticket.getTitle(),
            ticket.getDescription(),
            ticket.getTerm(),
            ticket.getPriority(),
            userMapper.toUserEntity(ticket.getRequester()),
            ticket.getStatus(),
            ticket.getCreatedAt(),
            ticket.getUpdatedAt()
        );
    }

    public Ticket toTicket(CreateTicketRequest request, com.example.domain.User user) {
        return new Ticket(
            request.title(),
            request.description(),
            request.term(),
            request.priority(),
            user
        );
    }

    public Ticket toTicket(TicketEntity entity) {
        return new Ticket(
            entity.getId(),
            entity.getCode(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getTerm(),
            entity.getPriority(),
            userMapper.toUser(entity.getRequester()),
            entity.getStatus(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }


}