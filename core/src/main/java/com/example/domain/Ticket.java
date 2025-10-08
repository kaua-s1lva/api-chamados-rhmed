package com.example.domain;

import java.time.LocalDate;
import java.util.UUID;

import com.example.domain.enums.TicketPriorityEnum;
import com.example.domain.enums.TicketStatusEnum;

public class Ticket {
    private Long id;
    private String code;
    private String title;
    private String description;
    private LocalDate term;
    private TicketPriorityEnum priority;
    private User requester;
    private TicketStatusEnum status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Ticket(String title, String description, LocalDate term, TicketPriorityEnum priority, User requester) {
        this.code = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.term = term;
        this.priority = priority;
        this.requester = requester;
        this.status = TicketStatusEnum.ABERTO;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Ticket(Long id, String code, String title, String description, LocalDate term, TicketPriorityEnum priority,
            User requester, TicketStatusEnum status, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.term = term;
        this.priority = priority;
        this.requester = requester;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
}
