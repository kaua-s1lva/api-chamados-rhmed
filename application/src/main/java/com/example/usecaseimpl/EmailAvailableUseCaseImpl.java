package com.example.usecaseimpl;

import com.example.EmailAvailableUseCase;
import com.example.gateway.EmailAvailableGateway;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase{
    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailableEmail(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
