package com.example.ticket_rhmed.dto.ticket;

import com.example.ticket_rhmed.dto.UserSummaryDTO;
import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketPriority;
import com.example.ticket_rhmed.models.TicketStatus;

import java.time.LocalDate;

public record TicketResponseDTO(
        Long id,
        String code,
        String title,
        String description,
        LocalDate term,
        TicketPriority priority,
        TicketStatus status,
        UserSummaryDTO requester
) {
    public TicketResponseDTO(Ticket ticket) {
        this(
                ticket.getId(),
                ticket.getCode(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getTerm(),
                ticket.getPriority(),
                ticket.getStatus(),
                new UserSummaryDTO(ticket.getRequester().getName(), ticket.getRequester().getEmail()));
    }
}