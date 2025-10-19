package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.domain.exception.NotFoundException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.UserEntity;
import com.example.gateway.UpdateUserGateway;
import com.example.repository.UserEntityRepository;
import com.example.security.IAuthenticationFacade;

@Service
public class UpdateUserGatewayImpl implements UpdateUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final IAuthenticationFacade authenticationFacade;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserGatewayImpl(
        UserEntityRepository userEntityRepository, 
        IAuthenticationFacade authenticationFacade,
        PasswordEncoder passwordEncoder
    ) {
        this.userEntityRepository = userEntityRepository;
        this.authenticationFacade = authenticationFacade;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Boolean update(User user) {
        UserEntity userEntity = authenticationFacade.getAuthenticatedUser();

        Optional.ofNullable(user.getName()).ifPresent(userEntity::setName);
        Optional.ofNullable(user.getEmail()).ifPresent(userEntity::setEmail);
        Optional.ofNullable(user.getPassword()).ifPresent(p -> userEntity.setPassword(passwordEncoder.encode(p)));
        userEntity.setUpdateAt(LocalDateTime.now());

        userEntityRepository.save(userEntity);

        return true;
    }

}
