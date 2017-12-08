package com.bike.marathon.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

	Event findById(Long id);

	List<Event> findByCity(String cityName);

}
