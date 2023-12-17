# A Spring Boot Demo

This is a small Spring Boot project that can pull events data from the Mixpanel API and saving them to a MySQL database.

Please note that this is not a complete code; I have only demonstrated the main functionalities and modules, and it cannot currently run.

## Project Structure

- src
  - main
    - java
      - com
        - example
          - demo
            - controller
              - EventController.java
            - entity
              - Event.java
              - EventProperties.java
            - repository
              - EventRepository.java
              - EventPropertiesRepository.java
            - service
              - EventService.java
            - DemoApplication.java

- **Event:** Entity class representing an event.
- **EventProperties:** Entity class representing a property associated with an event.
- **EventRepository:** Spring Data JPA repository for managing events in the database.
- **EventPropertiesRepository:** Spring Data JPA repository for managing event properties in the database.
- **EventService:** Service class to pull events from Mixpanel API and saving them to the database.
- **EventController:** RESTful API controller for triggering event processing.

## Setup

1. Configure MySQL database connection in the `application.properties` file.

2. Build the project using Maven: `mvn clean install`.

3. Trigger event processing by sending a POST request to `/api/events/pull-event-data`.


