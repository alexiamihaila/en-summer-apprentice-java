package com.endava.practica2023.Domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "venue")
public class Venue {

    @Id
    @Column(name = "venue_id")
    private Integer venueId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "venue")
    private Set<Eventss> eventss;


    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
