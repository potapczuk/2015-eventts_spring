package com.potapczuk.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.potapczuk.core.service.BaseService;
import com.potapczuk.events.entity.Event;
import com.potapczuk.events.repository.EventRepository;

@Service
public class EventService extends BaseService<Event> {

	@Autowired
	private EventRepository repository;

	public Page<Event> findAll(Pageable page) {
		return repository.findAll(page);
	}

	public Event findOne(Long id) {
		return repository.findOne(id);
	}

	public Event save(Event entity) {
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
