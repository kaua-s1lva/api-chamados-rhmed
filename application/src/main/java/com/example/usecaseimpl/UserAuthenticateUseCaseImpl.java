package com.example.usecaseimpl;

import com.example.UserAuthenticateUseCase;
import com.example.domain.exception.AuthenticateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.UserAuthenticateGateway;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String email, String password) throws AuthenticateException {
        if (!userAuthenticateGateway.authenticate(email, password)) {
            throw new AuthenticateException(ErrorCodeEnum.ATH001.getMessage(), ErrorCodeEnum.ATH001.getCode());
        }
        return true;
    }

}
