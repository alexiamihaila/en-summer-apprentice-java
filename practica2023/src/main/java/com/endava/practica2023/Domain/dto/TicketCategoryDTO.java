package com.endava.practica2023.Domain.dto;

import jakarta.persistence.Column;

public record TicketCategoryDTO(
    Integer ticket_category_id,
    String ticket_category_description,
    Float ticket_category_price
){}
