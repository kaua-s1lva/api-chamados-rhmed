package com.example.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;
import com.example.domain.exception.NotFoundException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.TicketHistoryEntity;
import com.example.gateway.ChangeTicketStatusGateway;
import com.example.gateway.ChangeTicketStatusHandlerGateway;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;
import com.example.repository.TicketHistoryEntityRepository;
import com.example.security.IAuthenticationFacade;
import com.example.repository.TicketEntityRepository;

@Service
public class ChangeTicketStatusGatewayImpl implements ChangeTicketStatusGateway {
    private final Map<TicketActionEnum, ChangeTicketStatusHandlerGateway> actionMap;
    private final TicketHistoryEntityRepository assistyTicketEntityRepository;
    private final TicketEntityRepository ticketEntityRepository;
    private final UserMapper userMapper;
    private final TicketMapper ticketMapper;
    private final IAuthenticationFacade authenticationFacade;

    public ChangeTicketStatusGatewayImpl(
        Map<TicketActionEnum, ChangeTicketStatusHandlerGateway> actionMap,
        TicketHistoryEntityRepository assistyTicketEntityRepository,
        TicketEntityRepository ticketEntityRepository,
        UserMapper userMapper,
        IAuthenticationFacade authenticationFacade,
        TicketMapper ticketMapper
    ) {
        this.actionMap = actionMap;
        this.assistyTicketEntityRepository = assistyTicketEntityRepository;
        this.ticketEntityRepository = ticketEntityRepository;
        this.userMapper = userMapper;
        this.authenticationFacade = authenticationFacade;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public void change(Long ticketId, TicketActionEnum action, String comment) {

        ChangeTicketStatusHandlerGateway handler = actionMap.get(action);
        if (handler == null) {
            throw new IllegalArgumentException("Ação não suportada");
        }

        User user = userMapper.toUser(authenticationFacade.getAuthenticatedUser());

        Ticket ticket = ticketMapper.toTicket(ticketEntityRepository.findById(ticketId).orElseThrow(
            () -> new NotFoundException(ErrorCodeEnum.TKT003.getMessage(), ErrorCodeEnum.TKT003.getCode())
        ));

        handler.changeStatus(ticket, user, comment);
        registryAssist(ticket, action, user, comment);
    }

    private void registryAssist(Ticket ticket, TicketActionEnum action, User user, String comment) {

        TicketHistoryEntity ticketHistoryEntity = new TicketHistoryEntity();
        ticketHistoryEntity.setTicket(ticketMapper.toTicketEntity(ticket));
        ticketHistoryEntity.setStatus(ticket.getStatus());
        ticketHistoryEntity.setUser(userMapper.toUserEntity(user));
        ticketHistoryEntity.setComment(comment);
        ticketHistoryEntity.setCreatedAt(LocalDateTime.now());
        ticketHistoryEntity.setUpdatedAt(LocalDateTime.now());
        
        assistyTicketEntityRepository.save(ticketHistoryEntity);
    }

}
