package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.exception.AuthenticateException;
import com.example.domain.exception.NotFoundException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.TicketEntity;
import com.example.gateway.UpdateTicketGateway;
import com.example.repository.TicketEntityRepository;
import com.example.security.IAuthenticationFacade;

@Service
public class UpdateTicketGatewayImpl implements UpdateTicketGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final IAuthenticationFacade authenticationFacade;

    public UpdateTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, IAuthenticationFacade authenticationFacade) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public Boolean update(Long ticketId, Ticket ticket) {
        TicketEntity ticketEntity = ticketEntityRepository.findById(ticketId).orElseThrow(
            () -> new NotFoundException(ErrorCodeEnum.TKT003.getMessage(), ErrorCodeEnum.TKT003.getCode())
        );

        if (!ticketEntity.getRequester().getId().equals(authenticationFacade.getAuthenticatedUser().getId())) {
            throw new AuthenticateException(ErrorCodeEnum.USR004.getMessage(), ErrorCodeEnum.USR004.getCode());
        }

        Optional.ofNullable(ticket.getTitle()).ifPresent(ticketEntity::setTitle);
        Optional.ofNullable(ticket.getDescription()).ifPresent(ticketEntity::setDescription);
        Optional.ofNullable(ticket.getPriority()).ifPresent(ticketEntity::setPriority);
        Optional.ofNullable(ticket.getTerm()).ifPresent(ticketEntity::setTerm);
        ticketEntity.setUpdatedAt(LocalDateTime.now());

        ticketEntityRepository.save(ticketEntity);
        return true;
    }

}
