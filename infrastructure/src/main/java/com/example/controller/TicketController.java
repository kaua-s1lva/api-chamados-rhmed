package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreateTicketUseCase;
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

    public TicketController(CreateTicketUseCase createTicketUseCase, TicketMapper ticketMapper, UserMapper userMapper) {
        this.createTicketUseCase = createTicketUseCase;
        this.ticketMapper = ticketMapper;
        this.userMapper = userMapper;
    }

    @PostMapping
    public BaseResponse<String> createTicket(@RequestBody CreateTicketRequest request, @AuthenticationPrincipal UserEntity userEntity) throws Exception {
        createTicketUseCase.create(ticketMapper.toTicket(request, userMapper.toUser(userEntity)));
        return BaseResponse.<String>builder().success(true).message("Ticket criado com sucesso").build();
    }
}
