package com.potapczuk.events.repository;

import java.util.List;

import com.potapczuk.events.entity.Event;


public interface EventRepositoryCustom {
	public List<Event> getTenBestEvents();
}
