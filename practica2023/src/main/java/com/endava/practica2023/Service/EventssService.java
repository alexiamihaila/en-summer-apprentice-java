package com.endava.practica2023.Service;

import com.endava.practica2023.Domain.EventType;
import com.endava.practica2023.Domain.Eventss;
import com.endava.practica2023.Domain.Venue;
import com.endava.practica2023.Domain.dto.EventssDTO;
import com.endava.practica2023.Domain.dto.TicketCategoryDTO;
import com.endava.practica2023.Repository.EventTypeRepository;
import com.endava.practica2023.Repository.EventssRepository;
import com.endava.practica2023.Repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventssService {
    private final EventssRepository eventssRepository;
    private final VenueRepository venueRepository;
    private final EventTypeRepository eventTypeRepository;

    public EventssService(EventssRepository eventssRepository, VenueRepository venueRepository,  EventTypeRepository eventTypeRepository){
        this.eventssRepository = eventssRepository;
        this.venueRepository = venueRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    public List<EventssDTO> getEventsByVenueAndTypeName(Integer venueId, String eventTypeName){

        Venue venue = venueRepository.findById(venueId).get();
        EventType eventType = eventTypeRepository.findEventTypeByEventTypeName(eventTypeName);


        return eventssRepository.findAllByVenueAndEventType(venue, eventType)
                .stream()
                .map(eventss -> new EventssDTO(
                       eventss.getEventId(),
                       eventss.getVenue(),
                       eventss.getEventType().getEventTypeName(),
                       eventss.getEventDescription(),
                        eventss.getEventName(),
                       eventss.getStartDate(),
                       eventss.getEndDate(),
                        eventss.getTicketCategory()
                                .stream()
                                .map( t -> new TicketCategoryDTO(t.getTicket_category_id(),
                                        t.getTicket_category_description(),
                                        t.getTicket_category_price()))
                                .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }

}
