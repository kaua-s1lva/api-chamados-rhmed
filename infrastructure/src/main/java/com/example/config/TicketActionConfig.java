package com.example.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domain.enums.TicketActionEnum;
import com.example.gateway.ChangeTicketStatusHandlerGateway;
import com.example.service.tickethandler.AnalyzeTicketGatewayImpl;
import com.example.service.tickethandler.ApproveAnalysisTicketGatewayImpl;
import com.example.service.tickethandler.ApproveValidationTicketGatewayImpl;
import com.example.service.tickethandler.CancelTicketGatewayImpl;
import com.example.service.tickethandler.RejectValidationTicketGatewayImpl;
import com.example.service.tickethandler.RequestInformationTicketGatewayImpl;
import com.example.service.tickethandler.ValidateTicketGatewayImpl;

@Configuration
public class TicketActionConfig {
    @Bean
    public Map<TicketActionEnum, ChangeTicketStatusHandlerGateway> actionMap(
        AnalyzeTicketGatewayImpl analyze,
        ValidateTicketGatewayImpl validate,
        ApproveAnalysisTicketGatewayImpl approveAnalysisTicket,
        RequestInformationTicketGatewayImpl requestInformation,
        ApproveValidationTicketGatewayImpl approveValidation,
        RejectValidationTicketGatewayImpl rejectValidation,
        CancelTicketGatewayImpl cancel
    ) {
        Map<TicketActionEnum,ChangeTicketStatusHandlerGateway> map = new EnumMap<>(TicketActionEnum.class);
        map.put(TicketActionEnum.ANALYZE, analyze);
        map.put(TicketActionEnum.VALIDATE, validate);
        map.put(TicketActionEnum.APPROVE_ANALYSIS, approveAnalysisTicket);
        map.put(TicketActionEnum.REQUEST_INFORMATION, requestInformation);
        map.put(TicketActionEnum.APPROVE_VALIDATION, approveValidation);
        map.put(TicketActionEnum.REJECT_VALIDATION, rejectValidation);
        map.put(TicketActionEnum.CANCEL, cancel);
        return map;
    }
}
