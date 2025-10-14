package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AnalyzeTicketUseCase;
import com.example.CreateTicketUseCase;
import com.example.dto.request.CreateTicketRequest;
import com.example.dto.response.BaseResponse;
import com.example.entity.TicketEntity;
import com.example.entity.UserEntity;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    private final AnalyzeTicketUseCase analyzeTicketUseCase;
    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;

    public TicketController(
        CreateTicketUseCase createTicketUseCase, 
        TicketMapper ticketMapper, 
        UserMapper userMapper,
        AnalyzeTicketUseCase analyzeTicketUseCase
    ) {
        this.createTicketUseCase = createTicketUseCase;
        this.ticketMapper = ticketMapper;
        this.userMapper = userMapper;
        this.analyzeTicketUseCase = analyzeTicketUseCase;
    }

    @PostMapping
    public BaseResponse<String> createTicket(@RequestBody CreateTicketRequest request, @AuthenticationPrincipal UserEntity userEntity) throws Exception {
        createTicketUseCase.create(ticketMapper.toTicket(request, userMapper.toUser(userEntity)));
        return BaseResponse.<String>builder().success(true).message("Ticket criado com sucesso").build();
    }

    @PutMapping("/analyze/{ticketId}")
    public BaseResponse<String> analyzeTicket(@PathVariable Long ticketId, @AuthenticationPrincipal UserEntity userEntity) throws Exception {
        analyzeTicketUseCase.analyze(ticketId, userMapper.toUser(userEntity));
        return BaseResponse.<String>builder().success(true).message("Ticket analisado com sucesso").build();
    }
}
