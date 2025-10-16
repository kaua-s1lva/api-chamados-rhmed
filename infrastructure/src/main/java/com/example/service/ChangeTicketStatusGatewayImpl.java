package com.example.service;

import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.domain.enums.TicketActionEnum;
import com.example.gateway.ChangeTicketStatusGateway;

@Service
@Primary
public class ChangeTicketStatusGatewayImpl implements ChangeTicketStatusGateway {
    private final Map<TicketActionEnum, ChangeTicketStatusGateway> actionMap;

    public ChangeTicketStatusGatewayImpl(Map<TicketActionEnum, ChangeTicketStatusGateway> actionMap) {
        this.actionMap = actionMap;
    }

    @Override
    public Boolean change(Long ticketId, TicketActionEnum action, User user, String comment) {
        
        // TicketActionEnum action;
        // try {
        //     action = TicketActionEnum.valueOf(request.action().toUpperCase());
        // } catch (IllegalArgumentException e) {
        //     return BaseResponse.<String>builder().success(false).message("Ação inválida").build();
        // }

        ChangeTicketStatusGateway handler = actionMap.get(action);
        if (handler == null) {
            throw new IllegalArgumentException("Ação não suportada");
        }

        try {
            handler.change(ticketId, action, user, comment);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
