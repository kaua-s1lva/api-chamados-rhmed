package com.example.dto.request;

import java.time.LocalDate;

import com.example.domain.enums.TicketPriorityEnum;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTicketRequest(
    @NotBlank String title, 
    @NotBlank String description, 
    @NotNull @FutureOrPresent LocalDate term, 
    @NotNull TicketPriorityEnum priority
) {}