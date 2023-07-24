package com.endava.practica2023.Domain.dto;

import com.endava.practica2023.Domain.TicketCategory;
import com.endava.practica2023.Domain.Venue;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Set;

public record EventssDTO (
        Integer eventId,
        Venue venue,
        String eventType,
        String eventDescription,
        String eventName,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Set<TicketCategoryDTO> ticketCategory
){ }
