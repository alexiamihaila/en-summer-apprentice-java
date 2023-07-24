package com.endava.practica2023.Repository;

import com.endava.practica2023.Domain.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Integer> {

     EventType findEventTypeByEventTypeName(String eventTypeName);
}
