package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.domain.exception.CreateUserException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.CreateUserGateway;
import com.example.mapper.UserMapper;
import com.example.repository.UserEntityRepository;
import com.example.security.TokenSecurityService;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenSecurityService tokenService;
    private final UserMapper userMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, TokenSecurityService tokenService) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public String create(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userEntityRepository.save(userMapper.toUserEntity(user));

            String token = tokenService.generateToken(userMapper.toUserEntity(user));
            return token;
            
        } catch (Exception e) {
            throw new CreateUserException(ErrorCodeEnum.USR002.getMessage() + ": " + e.getMessage(), ErrorCodeEnum.USR002.getCode());
        }
    }
}
