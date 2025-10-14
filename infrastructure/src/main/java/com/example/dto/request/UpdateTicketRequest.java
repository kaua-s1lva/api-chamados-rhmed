package com.example.dto.request;

import java.time.LocalDate;

import com.example.domain.enums.TicketPriorityEnum;
import com.example.domain.enums.TicketStatusEnum;
import com.example.entity.UserEntity;

public record UpdateTicketRequest(
    Long id,
    String code,
    String title,
    String description,
    LocalDate term,
    TicketPriorityEnum priority,
    UserEntity requester,
    TicketStatusEnum status,
    LocalDate createdAt,
    LocalDate updatedAt
) {}
