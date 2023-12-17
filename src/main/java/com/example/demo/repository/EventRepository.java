package com.example.demo.repository;

import com.example.demo.entity.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface to manage Event entities.
 * Extends JPA CrudRepository which provide basic CRUD operations.
 */
public interface EventRepository extends CrudRepository<Event, Long> {
}
