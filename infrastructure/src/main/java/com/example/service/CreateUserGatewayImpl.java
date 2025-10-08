package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.gateway.CreateUserGateway;
import com.example.mapper.UserMapper;
import com.example.repository.UserEntityRepository;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean create(User user) {
        try {
            userEntityRepository.save(userMapper.toUserEntity(user));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
