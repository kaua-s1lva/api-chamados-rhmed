package com.example.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domain.enums.TicketActionEnum;
import com.example.gateway.ChangeTicketStatusGateway;
import com.example.service.AnalyzeTicketGatewayImpl;
import com.example.service.ApproveAnalysisTicketGatewayImpl;
import com.example.service.ApproveValidationTicketGatewayImpl;
import com.example.service.CancelTicketGatewayImpl;
import com.example.service.CompleteTicketGatewayImpl;
import com.example.service.RejectValidationTicketGatewayImpl;
import com.example.service.RequestInformationTicketGatewayImpl;
import com.example.service.ValidateTicketGatewayImpl;

@Configuration
public class TicketActionConfig {
    @Bean
    public Map<TicketActionEnum, ChangeTicketStatusGateway> actionMap(
        AnalyzeTicketGatewayImpl analyze,
        ValidateTicketGatewayImpl validate,
        ApproveAnalysisTicketGatewayImpl approveAnalysisTicket,
        RequestInformationTicketGatewayImpl requestInformation,
        ApproveValidationTicketGatewayImpl approveValidation,
        RejectValidationTicketGatewayImpl rejectValidation,
        CompleteTicketGatewayImpl complete,
        CancelTicketGatewayImpl cancel
    ) {
        Map<TicketActionEnum,ChangeTicketStatusGateway> map = new EnumMap<>(TicketActionEnum.class);
        map.put(TicketActionEnum.ANALYZE, analyze);
        map.put(TicketActionEnum.VALIDATE, validate);
        map.put(TicketActionEnum.APPROVE_ANALYSIS, approveAnalysisTicket);
        map.put(TicketActionEnum.REQUEST_INFORMATION, requestInformation);
        map.put(TicketActionEnum.APPROVE_VALIDATION, approveValidation);
        map.put(TicketActionEnum.REJECT_VALIDATION, rejectValidation);
        map.put(TicketActionEnum.COMPLETE, complete);
        map.put(TicketActionEnum.CANCEL, cancel);
        return map;
    }
}
