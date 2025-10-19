package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ChangeTicketStatusUseCase;
import com.example.CreateTicketUseCase;
import com.example.UpdateTicketUseCase;
import com.example.gateway.ChangeTicketStatusGateway;
import com.example.gateway.CreateTicketGateway;
import com.example.gateway.UpdateTicketGateway;
import com.example.mapper.TicketMapper;
import com.example.mapper.UserMapper;
import com.example.security.IAuthenticationFacade;
import com.example.usecaseimpl.ChangeTicketStatusUseCaseImpl;
import com.example.usecaseimpl.CreateTicketUseCaseImpl;
import com.example.usecaseimpl.UpdateTicketUseCaseImpl;

@Configuration
public class TicketConfig {
    @Bean
    public CreateTicketUseCase createTicketUseCase(CreateTicketGateway createTicketGateway) {
        return new CreateTicketUseCaseImpl(createTicketGateway);
    }

    @Bean
    public TicketMapper ticketMapper(UserMapper userMapper, IAuthenticationFacade authenticationFacade) {
        return new TicketMapper(userMapper, authenticationFacade);
    }

    @Bean
    public ChangeTicketStatusUseCase changeTicketStatusUseCase(ChangeTicketStatusGateway changeTicketStatusGateway) {
        return new ChangeTicketStatusUseCaseImpl(changeTicketStatusGateway);
    }

    @Bean
    public UpdateTicketUseCase updateTicketGateway(UpdateTicketGateway updateTicketGateway) {
        return new UpdateTicketUseCaseImpl(updateTicketGateway);
    }
}
