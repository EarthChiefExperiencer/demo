package com.example.demo.repository;
import com.example.demo.entity.EventProperties;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface to manage EventProperties entities.
 */
public interface EventPropertiesRepository extends CrudRepository<EventProperties, Long> {

}