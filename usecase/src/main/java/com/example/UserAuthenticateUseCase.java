package com.example;

import com.example.domain.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String email, String password) throws AuthenticateException;
}
