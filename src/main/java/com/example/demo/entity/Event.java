package com.example.demo.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Entity class Event,
 * an event has a name and a list of associated properties.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    private String eventName;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventProperties> properties;



    public List<EventProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<EventProperties> properties) {
        this.properties = properties;
    }
}
