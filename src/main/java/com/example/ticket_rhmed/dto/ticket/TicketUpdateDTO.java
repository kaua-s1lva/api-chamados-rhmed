package com.example.ticket_rhmed.dto.ticket;

import com.example.ticket_rhmed.models.TicketPriority;
import com.example.ticket_rhmed.models.TicketStatus;
import java.time.LocalDate;

public record TicketUpdateDTO(
    Long id,
    String title,
    String description,
    TicketStatus status,
    TicketPriority priority,
    LocalDate term,
    String comment
) {
}
