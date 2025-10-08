package com.example.service;

import org.springframework.stereotype.Service;

import com.example.gateway.EmailAvailableGateway;
import com.example.repository.UserEntityRepository;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }

}
