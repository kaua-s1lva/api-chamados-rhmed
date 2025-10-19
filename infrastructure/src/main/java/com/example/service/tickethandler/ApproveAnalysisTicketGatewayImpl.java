package com.example.service.tickethandler;

import org.springframework.stereotype.Service;

import com.example.domain.Ticket;
import com.example.domain.User;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.ChangeTicketStatusHandlerGateway;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketEntityRepository;

@Service
public class ApproveAnalysisTicketGatewayImpl implements ChangeTicketStatusHandlerGateway {
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper ticketMapper;

    public ApproveAnalysisTicketGatewayImpl(TicketEntityRepository ticketEntityRepository, TicketMapper ticketMapper) {
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public void changeStatus(Ticket ticket, User user, String comment) throws ChangeStateException {
        if (!user.isAdmin()) {
            throw new ChangeStateException(ErrorCodeEnum.USR004.getMessage(), ErrorCodeEnum.USR004.getCode());
        }
        ticket.approveAnalysis();
        ticketEntityRepository.save(ticketMapper.toTicketEntity(ticket));
    }
}
