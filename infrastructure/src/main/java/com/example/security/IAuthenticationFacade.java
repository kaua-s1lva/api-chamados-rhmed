package com.example.security;

import com.example.entity.UserEntity;

public interface IAuthenticationFacade {
    UserEntity getAuthenticatedUser();    
}
