package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.CreateUserUseCase;
import com.example.EmailAvailableUseCase;
import com.example.UpdateUserUseCase;
import com.example.UserAuthenticateUseCase;
import com.example.gateway.CreateUserGateway;
import com.example.gateway.EmailAvailableGateway;
import com.example.gateway.UpdateUserGateway;
import com.example.gateway.UserAuthenticateGateway;
import com.example.usecaseimpl.CreateUserUseCaseImpl;
import com.example.usecaseimpl.EmailAvailableUseCaseImpl;
import com.example.usecaseimpl.UpdateUserUseCaseImpl;
import com.example.usecaseimpl.UserAuthenticateUseCaseImpl;

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

    @Bean
    public UserAuthenticateUseCase userAuthenticateUseCase(UserAuthenticateGateway userAuthenticateGateway) {
        return new UserAuthenticateUseCaseImpl(userAuthenticateGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UpdateUserGateway updateUserGateway) {
        return new UpdateUserUseCaseImpl(updateUserGateway);
    }
}
