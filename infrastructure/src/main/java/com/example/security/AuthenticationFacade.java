package com.example.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.domain.exception.AuthenticateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.entity.UserEntity;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    public UserEntity getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof UserEntity)) {
            throw new AuthenticateException(ErrorCodeEnum.ATH001.getMessage(), ErrorCodeEnum.ATH001.getCode());
        }

        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        return userDetails;
    }
    
}
