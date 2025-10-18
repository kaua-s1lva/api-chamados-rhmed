package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.exception.AuthenticateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.UserEntity;
import com.example.gateway.UserAuthenticateGateway;
import com.example.repository.UserEntityRepository;
import com.example.security.TokenSecurityService;

@Service
public class UserAuthenticateGatewayImpl implements UserAuthenticateGateway {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenSecurityService tokenService;

    public UserAuthenticateGatewayImpl(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder, TokenSecurityService tokenService) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public String authenticate(String email, String password) {
        UserEntity userEntity = userEntityRepository.findByEmail(email).orElseThrow(
            () -> new AuthenticateException(ErrorCodeEnum.ATH001.getMessage(), ErrorCodeEnum.ATH001.getCode())
        );

        if (passwordEncoder.matches(password, userEntity.getPassword())) {
            String token = tokenService.generateToken(userEntity);
            return token;
        } else {
            throw new AuthenticateException(ErrorCodeEnum.ATH002.getMessage(), ErrorCodeEnum.ATH002.getCode());
        }
        
    }
    
}
