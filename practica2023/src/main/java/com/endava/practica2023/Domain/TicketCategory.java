package com.endava.practica2023.Domain;

import jakarta.persistence.*;
import jdk.jfr.Event;

import java.util.Set;

@Entity
@Table(name = "ticket_category")
public class TicketCategory {

    @Id
    @Column(name = "ticket_category_id")
    private Integer ticket_category_id;

    @Column(name = "ticket_category_description")
    private String ticket_category_description;

    @Column(name = "ticket_category_price")
    private Float ticket_category_price;

    @OneToMany(mappedBy = "ticketCategory")
    private Set<Orders> orders;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Eventss eventss;

    public Integer getTicket_category_id() {
        return ticket_category_id;
    }

    public void setTicket_category_id(Integer ticket_category_id) {
        this.ticket_category_id = ticket_category_id;
    }

    public String getTicket_category_description() {
        return ticket_category_description;
    }

    public void setTicket_category_description(String ticket_category_description) {
        this.ticket_category_description = ticket_category_description;
    }

    public Float getTicket_category_price() {
        return ticket_category_price;
    }

    public void setTicket_category_price(Float ticket_category_price) {
        this.ticket_category_price = ticket_category_price;
    }

    public Eventss getEventss() {
        return eventss;
    }

    public void setEventss(Eventss eventss) {
        this.eventss = eventss;
    }

}
