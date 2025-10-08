package com.example.ticket_rhmed.dto.handling;

import com.example.ticket_rhmed.models.TicketStatus;

public record HandlingRequestDTO(
    TicketStatus status, 
    String comment, 
    Long ticket_id
) {
    
}
