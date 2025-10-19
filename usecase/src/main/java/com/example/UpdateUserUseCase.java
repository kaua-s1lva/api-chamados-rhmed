package com.example;

import com.example.domain.User;
import com.example.domain.exception.UserException;

public interface UpdateUserUseCase {
    void update(User user) throws UserException;
}
