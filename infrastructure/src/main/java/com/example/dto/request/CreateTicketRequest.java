package com.example.dto.request;

import java.time.LocalDate;

import com.example.domain.enums.TicketPriorityEnum;

public record CreateTicketRequest(
    String title, 
    String description, 
    LocalDate term, 
    TicketPriorityEnum priority
) {}