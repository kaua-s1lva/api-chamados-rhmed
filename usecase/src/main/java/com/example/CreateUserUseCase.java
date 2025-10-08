package com.example;

import com.example.domain.User;
import com.example.domain.exception.EmailException;
import com.example.domain.exception.InternalServerErrorException;

public interface CreateUserUseCase {
    void create(User user) throws EmailException, InternalServerErrorException;
}
