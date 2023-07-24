package com.endava.practica2023.Repository;

import com.endava.practica2023.Domain.EventType;
import com.endava.practica2023.Domain.Eventss;
import com.endava.practica2023.Domain.Venue;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventssRepository extends JpaRepository<Eventss, Integer> {

    List<Eventss> findAllByVenueAndEventType(Venue venue, EventType eventType);
}