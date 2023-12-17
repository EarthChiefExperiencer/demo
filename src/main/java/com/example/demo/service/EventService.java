package com.example.demo.service;

import com.example.demo.entity.Event;
import com.example.demo.entity.EventProperties;
import com.example.demo.repository.EventPropertiesRepository;
import com.example.demo.repository.EventRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pull data from Mixpanel API,
 * process the response data and save to database.
 * Use JPA cascade save
 */
@Service
public class EventService
{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventPropertiesRepository eventPropertiesRepository;

    public void pullEventDataAndSaveToDatabase() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://data.mixpanel.com/api/2.0/export?project_id=11&from_date=2023-11-01&to_date=2023-12-01")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic QW5jb3JhOkFuY29yYQ==")// I don't have authorization so it's just simulation
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                processMixpanelAPIResponse(responseData);
            } else {

                System.out.println("Error: " + response.code() + " - " + response.message());
            }
        }
    }


    private void processMixpanelAPIResponse(String responseData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseData);

        if (root.has("event") && root.has("properties")) {
            String eventName = root.get("event").asText();
            JsonNode propertiesNode = root.get("properties");

            Event event = new Event();
            event.setEventName(eventName);

            List<EventProperties> eventProperties = new ArrayList<>();
            propertiesNode.fields().forEachRemaining(entry -> {
                EventProperties properties = new EventProperties();
                properties.setPropertyName(entry.getKey());
                properties.setPropertyValue(entry.getValue().asText());
                properties.setEvent(event);
                eventProperties.add(properties);
            });

            event.setProperties(eventProperties);

            saveDataToDatabase(event);
        } else {

            System.out.println("Invalid response");
        }
    }

    //When saving an Event, its associated EventProperties are also saved
    private void saveDataToDatabase(Event event) {
        eventRepository.save(event);
    }
}
