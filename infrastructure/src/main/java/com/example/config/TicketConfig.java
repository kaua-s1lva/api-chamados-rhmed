package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.AnalyzeTicketUseCase;
import com.example.CreateTicketUseCase;
import com.example.gateway.AnalyzeTicketGateway;
import com.example.gateway.CreateTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;
import com.example.usecaseimpl.AnalyzeTicketUseCaseImpl;
import com.example.usecaseimpl.CreateTicketUseCaseImpl;

@Configuration
public class TicketConfig {
    @Bean
    public CreateTicketUseCase createTicketUseCase(CreateTicketGateway createTicketGateway) {
        return new CreateTicketUseCaseImpl(createTicketGateway);
    }

    @Bean
    public TicketMapper ticketMapper(UserMapper userMapper) {
        return new TicketMapper(userMapper);
    }

    @Bean
    public AnalyzeTicketUseCase analyzeTicketUseCase(AnalyzeTicketGateway analyzeTicketGateway) {
        return new AnalyzeTicketUseCaseImpl(analyzeTicketGateway);
    }
}
