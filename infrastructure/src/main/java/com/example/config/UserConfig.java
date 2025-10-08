package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.CreateUserUseCase;
import com.example.EmailAvailableUseCase;
import com.example.gateway.CreateUserGateway;
import com.example.gateway.EmailAvailableGateway;
import com.example.usecaseimpl.CreateUserUseCaseImpl;
import com.example.usecaseimpl.EmailAvailableUseCaseImpl;

@Configuration
public class UserConfig {

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(emailAvailableUseCase, createUserGateway);
    }
}
