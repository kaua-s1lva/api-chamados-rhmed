package com.example.usecaseimpl;

import com.example.CreateUserUseCase;
import com.example.EmailAvailableUseCase;
import com.example.domain.User;
import com.example.domain.exception.EmailException;
import com.example.domain.exception.InternalServerErrorException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.CreateUserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public String create(User user) throws EmailException, InternalServerErrorException{
        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.USR001.getMessage(), ErrorCodeEnum.USR001.getCode());
        }

        String token = createUserGateway.create(user);
        if (token == null) {
            throw new InternalServerErrorException(ErrorCodeEnum.USR002.getMessage(), ErrorCodeEnum.USR002.getCode());
        }
        return token;

        // if (createUserGateway.create(user)) {
        //     throw new InternalServerErrorException(ErrorCodeEnum.USR002.getMessage(), ErrorCodeEnum.USR002.getCode());
        // }
    }
}
