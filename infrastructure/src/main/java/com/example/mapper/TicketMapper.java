package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.domain.Ticket;
import com.example.dto.request.SaveTicketRequest;
import com.example.entity.TicketEntity;
import com.example.security.IAuthenticationFacade;

@Component
public class TicketMapper {
    private final UserMapper userMapper;
    private final IAuthenticationFacade authenticationFacade;

    public TicketMapper(UserMapper userMapper, IAuthenticationFacade authenticationFacade) {
        this.userMapper = userMapper;
        this.authenticationFacade = authenticationFacade;
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

    public Ticket toTicket(SaveTicketRequest request) {
        return new Ticket(
            request.title(),
            request.description(),
            request.term(),
            request.priority(),
            userMapper.toUser(authenticationFacade.getAuthenticatedUser())
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