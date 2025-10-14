package com.example.usecaseimpl;
    
import com.example.AnalyzeTicketUseCase;
import com.example.domain.User;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.gateway.AnalyzeTicketGateway;

public class AnalyzeTicketUseCaseImpl implements AnalyzeTicketUseCase {
    private final AnalyzeTicketGateway analyzeTicketGateway;

    public AnalyzeTicketUseCaseImpl(AnalyzeTicketGateway analyzeTicketGateway) {
        this.analyzeTicketGateway = analyzeTicketGateway;
    }

    @Override
    public void analyze(Long ticketId, User user) throws Exception {
        if (!analyzeTicketGateway.analyze(ticketId, user)) {
            throw new ChangeStateException(ErrorCodeEnum.TKT002.getMessage(), ErrorCodeEnum.TKT002.getCode());
        }
        // Ticket ticket = findTicketByIdGateway.findById(ticketId);
        // if (ticket == null) {
        //     throw new NotFoundException(ErrorCodeEnum.TKT003.getMessage(), ErrorCodeEnum.TKT003.getCode());
        // }
        // ticket.analyze();
        // changeTicketStatusUseCase.change(ticket, ticket.status);
    }

    // @Override
    // public void change(Ticket ticket, com.example.domain.ticketstatus.TicketStatusState state) throws ChangeStateException {
    //     changeTicketStatusUseCase.change(ticket, state);
    // }
}
