package com.example;

import com.example.domain.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    String authenticate(String email, String password) throws AuthenticateException;
}
