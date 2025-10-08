package com.example.ticket_rhmed.dto.ticket;

import java.time.LocalDate;

import com.example.ticket_rhmed.models.TicketPriority;

public record TicketRequestDTO(
    String code, 
    String title, 
    String description, 
    TicketPriority priority, 
    LocalDate term
) {}
