package com.example.demo.controller;

import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * RESTful API Facilitate interaction with front-end applications
 *
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/pull-event-data")
    public String pullEventDataAndSaveEvents() {
        try {
            eventService.pullEventDataAndSaveToDatabase();
            return "Events saved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error!";
        }
    }
}