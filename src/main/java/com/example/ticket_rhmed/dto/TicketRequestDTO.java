package com.example.ticket_rhmed.dto;

import java.time.LocalDate;

import com.example.ticket_rhmed.models.TicketPriority;
import com.example.ticket_rhmed.models.TicketStatus;

public record TicketRequestDTO(
    String code, 
    String title, 
    String description, 
    TicketStatus status,
    TicketPriority priority, 
    LocalDate term
) {}
