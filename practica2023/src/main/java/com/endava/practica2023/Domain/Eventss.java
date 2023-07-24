package com.endava.practica2023.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "eventss")
public class Eventss {
    @Id
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @OneToMany(mappedBy = "eventss")
    @JsonIgnore
    private Set<TicketCategory> ticketCategory;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }


    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Set<TicketCategory> getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(Set<TicketCategory> ticketCategory) {
        this.ticketCategory = ticketCategory;
    }


}
