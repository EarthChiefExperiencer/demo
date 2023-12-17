package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * Entity class EventPropertie,
 * a property associated with an event.
 */
@Entity
public class EventProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String propertyName;
    private String propertyValue;

    @ManyToOne
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
