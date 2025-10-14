package com.example;

import com.example.domain.User;

public interface AnalyzeTicketUseCase {
    void analyze(Long ticketId, User user) throws Exception;
}
