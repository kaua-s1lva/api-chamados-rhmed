package com.example.service;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;
import com.example.entity.TicketHistoryEntity;
import com.example.entity.TicketEntity;
import com.example.gateway.ChangeTicketStatusGateway;
import com.example.mapper.UserMapper;
import com.example.repository.TicketHistoryEntityRepository;
import com.example.repository.TicketEntityRepository;

@Service
@Primary
public class ChangeTicketStatusGatewayImpl implements ChangeTicketStatusGateway {
    private final Map<TicketActionEnum, ChangeTicketStatusGateway> actionMap;
    private final TicketHistoryEntityRepository assistyTicketEntityRepository;
    private final TicketEntityRepository ticketEntityRepository;
    private final UserMapper userMapper;

    public ChangeTicketStatusGatewayImpl(
        Map<TicketActionEnum, ChangeTicketStatusGateway> actionMap,
        TicketHistoryEntityRepository assistyTicketEntityRepository,
        TicketEntityRepository ticketEntityRepository,
        UserMapper userMapper
    ) {
        this.actionMap = actionMap;
        this.assistyTicketEntityRepository = assistyTicketEntityRepository;
        this.ticketEntityRepository = ticketEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean change(Long ticketId, TicketActionEnum action, User user, String comment) {

        ChangeTicketStatusGateway handler = actionMap.get(action);
        if (handler == null) {
            throw new IllegalArgumentException("Ação não suportada");
        }

        try {
            handler.change(ticketId, action, user, comment);
        } catch (Exception e) {
            return false;
        }
        registryAssist(ticketId, action, user, comment);
        return true;
    }

    private void registryAssist(Long ticketId, TicketActionEnum action, User user, String comment) {
        TicketEntity ticketEntity = ticketEntityRepository.findById(ticketId).orElseThrow(
            () -> new IllegalArgumentException("Ticket not found")
        );

        TicketHistoryEntity ticketHistoryEntity = new TicketHistoryEntity();
        ticketHistoryEntity.setTicket(ticketEntity);
        ticketHistoryEntity.setStatus(ticketEntity.getStatus());
        ticketHistoryEntity.setUser(userMapper.toUserEntity(user));
        ticketHistoryEntity.setComment(comment);
        ticketHistoryEntity.setCreatedAt(LocalDate.now());
        ticketHistoryEntity.setUpdatedAt(LocalDate.now());
        
        assistyTicketEntityRepository.save(ticketHistoryEntity);
    }

}
