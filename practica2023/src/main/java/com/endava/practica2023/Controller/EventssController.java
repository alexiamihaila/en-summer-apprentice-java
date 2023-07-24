package com.endava.practica2023.Controller;

import com.endava.practica2023.Domain.Eventss;
import com.endava.practica2023.Domain.dto.EventssDTO;
import com.endava.practica2023.Service.EventssService;
import jdk.jfr.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventssController {
    private final EventssService eventssService;

    public EventssController(EventssService eventssService){
        this.eventssService = eventssService;
    }


    @GetMapping("/api/getEvents/{venueId}/{eventTypeName}")
    public List<EventssDTO> getEventsByVenueAndName(
            @PathVariable Integer venueId,
            @PathVariable String eventTypeName){
        return eventssService.getEventsByVenueAndTypeName(venueId, eventTypeName);
    }

}
