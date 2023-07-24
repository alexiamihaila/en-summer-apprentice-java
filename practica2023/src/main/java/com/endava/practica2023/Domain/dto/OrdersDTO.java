package com.endava.practica2023.Domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

public record OrdersDTO (
        Integer eventId,
        LocalDateTime orderedAt,
        Integer ticketCategoryId,
        Integer number_of_tickets,
        Float order_total_price
){
    @Override
    public String toString() {
        return "{\n" +
                "eventId = " + eventId + ",\n" +
                "orderedAt = " + orderedAt + ",\n" +
                "ticketCategoryId = " + ticketCategoryId +  ",\n" +
                "number_of_tickets = " + number_of_tickets +  ",\n" +
                "order_total_price = " + order_total_price +  "\n" +
                '}';
    }
}

