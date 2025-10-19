package com.example.usecaseimpl;

import com.example.UpdateUserUseCase;
import com.example.domain.User;
import com.example.domain.exception.UserException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.UpdateUserGateway;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UpdateUserGateway updateUserGateway;

    public UpdateUserUseCaseImpl(UpdateUserGateway updateUserGateway) {
        this.updateUserGateway = updateUserGateway;
    }

    @Override
    public void update(User user) throws UserException {
        if (!updateUserGateway.update(user)) {
            throw new UserException(ErrorCodeEnum.USR002.getMessage(), ErrorCodeEnum.USR002.getCode());
        }
    }

}
