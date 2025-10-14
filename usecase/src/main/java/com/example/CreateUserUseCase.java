package com.example;

import com.example.domain.User;
import com.example.domain.exception.EmailException;
import com.example.domain.exception.InternalServerErrorException;

public interface CreateUserUseCase {
    String create(User user) throws EmailException, InternalServerErrorException;
}
