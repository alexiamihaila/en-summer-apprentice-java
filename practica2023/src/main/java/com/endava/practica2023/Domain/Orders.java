package com.endava.practica2023.Domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ordered_at")
    private LocalDateTime orderedAt;

    @Column(name = "number_of_tickets")
    private Integer numberOfTickets ;

    @Column(name = "order_total_price")
    private float orderOtotalPrice;

    @ManyToOne()
    @JoinColumn(name = "ticket_category_id")
    private TicketCategory ticketCategory;

    public Orders(){}

    public Orders(LocalDateTime orderedAt,Integer userId,TicketCategory ticketCategory, Integer numberOfTickets,Float orderOtotalPrice){
        this.orderedAt = orderedAt;
        this.userId = userId;
        this.ticketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
        this.orderOtotalPrice = orderOtotalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Integer getNumber_of_tickets() {
        return numberOfTickets;
    }

    public void setNumber_of_tickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public float getOrder_total_price() {
        return orderOtotalPrice;
    }

    public void setOrder_total_price(float order_total_price) {
        this.orderOtotalPrice = order_total_price;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

}
