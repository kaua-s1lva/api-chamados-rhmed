package com.example.dto.request;

import com.example.domain.enums.TicketActionEnum;

public record ActionTicketRequest (
    TicketActionEnum action,
    String comment
) {
    
}
