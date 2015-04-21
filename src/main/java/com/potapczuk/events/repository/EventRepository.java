package com.potapczuk.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.potapczuk.events.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>, EventRepositoryCustom {
	
	Event findEventByName(String name);
	
	@Query("SELECT f FROM Event f WHERE LOWER(f.name) = LOWER(:name)")
	Event findEventByNameSpecial(@Param("name") String name);
}
