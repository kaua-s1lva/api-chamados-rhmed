package com.example.gateway;

import com.example.domain.User;

public interface AnalyzeTicketGateway {
    Boolean analyze(Long ticketId, User user) throws Exception;
}
