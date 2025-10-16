package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChangeTicketStatusUseCase;
import com.example.CreateTicketUseCase;
import com.example.dto.request.ActionTicketRequest;
import com.example.dto.request.CreateTicketRequest;
import com.example.dto.response.BaseResponse;
import com.example.entity.UserEntity;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;
    private final ChangeTicketStatusUseCase changeTicketStatusUseCase;

    public TicketController(
        CreateTicketUseCase createTicketUseCase, 
        TicketMapper ticketMapper, 
        UserMapper userMapper,
        ChangeTicketStatusUseCase changeTicketStatusUseCase
    ) {
        this.createTicketUseCase = createTicketUseCase;
        this.ticketMapper = ticketMapper;
        this.userMapper = userMapper;
        this.changeTicketStatusUseCase = changeTicketStatusUseCase;
    }

    @PostMapping
    public BaseResponse<String> createTicket(@RequestBody CreateTicketRequest request, @AuthenticationPrincipal UserEntity userEntity) throws Exception {
        createTicketUseCase.create(ticketMapper.toTicket(request, userMapper.toUser(userEntity)));
        return BaseResponse.<String>builder().success(true).message("Ticket criado com sucesso").build();
    }

    @PutMapping("/{ticketId}/action")
    public BaseResponse<String> change(
        @PathVariable Long ticketId,
        @RequestBody ActionTicketRequest request,
        @AuthenticationPrincipal UserEntity userEntity
    ) throws Exception {
        changeTicketStatusUseCase.change(ticketId, request.action(), userMapper.toUser(userEntity), request.comment());
        return BaseResponse.<String>builder().success(true).message("Ação realizada com sucesso").build();
    }

}
