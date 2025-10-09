package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreateTicketUseCase;
import com.example.dto.request.CreateTicketRequest;
import com.example.dto.response.BaseResponse;
import com.example.mapper.TicketMapper;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    private final TicketMapper ticketMapper;

    public TicketController(CreateTicketUseCase createTicketUseCase, TicketMapper ticketMapper) {
        this.createTicketUseCase = createTicketUseCase;
        this.ticketMapper = ticketMapper;
    }

    @PostMapping
    public BaseResponse<String> createTicket(@RequestBody CreateTicketRequest request) throws Exception {
        createTicketUseCase.create(ticketMapper.toTicket(request));
        return BaseResponse.<String>builder().success(true).message("Ticket criado com sucesso").build();
    }
}
