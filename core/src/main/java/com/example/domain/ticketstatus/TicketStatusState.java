package com.example.domain.ticketstatus;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;

public abstract class TicketStatusState {
    protected Ticket ticket;
    
    public TicketStatusState(Ticket ticket) {
        this.ticket = ticket;
    }

    abstract public TicketStatusEnum getStatus();
    
    public void analyze() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void requestInformation() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void approveAnalysis() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void validate() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void approveValidation() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void rejectValidation() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }

    public void cancel() {
        throw new ChangeStateException(ErrorCodeEnum.TKT006.getMessage() + ". Estado atual: " + this.getStatus().name(), ErrorCodeEnum.TKT006.getCode());
    }
}
