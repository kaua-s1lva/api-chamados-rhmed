package com.example.domain.ticketstatus;

import java.util.HashMap;

import com.example.domain.Ticket;
import com.example.domain.enums.TicketStatusEnum;

public class TicketStatusStateFactory {
    private HashMap<TicketStatusEnum, TicketStatusState> states = new HashMap<>();

    public TicketStatusStateFactory(Ticket ticket) {
        states.put(TicketStatusEnum.ABERTO, new OpenTicketState(ticket));
        states.put(TicketStatusEnum.EM_ANALISE, new InAnalysisTicketState(ticket));
        states.put(TicketStatusEnum.AGUARDANDO_INFORMACOES, new RequestedInformationTicketState(ticket));
        states.put(TicketStatusEnum.EM_DESENVOLVIMENTO, new InDevelopmentTicketState(ticket));
        states.put(TicketStatusEnum.AGUARDANDO_APROVACAO, new WaitingApprovalTicketState(ticket));
        states.put(TicketStatusEnum.CONCLUIDO, new CompleteTicketState(ticket));
        states.put(TicketStatusEnum.CANCELADO, new CanceledTicketState(ticket));
    }

    public TicketStatusState create(TicketStatusEnum status) {
        if (states.containsKey(status)) {
            return states.get(status);
        }
        throw new RuntimeException("Estado não encontrado");
    }
}
