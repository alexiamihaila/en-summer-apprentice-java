package com.endava.practica2023.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "event_type")
public class EventType {
    @Id
    @Column(name = "event_type_id")
    private Integer eventTypeId;

    @Column(name = "event_type_name")
    private String eventTypeName;

    @OneToMany(mappedBy = "eventType")
    private Set<Eventss> events;

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }



}
