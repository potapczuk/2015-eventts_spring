package com.potapczuk.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.potapczuk.core.controller.mapping.BaseMapping;
import com.potapczuk.core.util.Flash;
import com.potapczuk.events.controller.EventController;
import com.potapczuk.events.controller.mapping.EventMapping;
import com.potapczuk.events.entity.Event;
import com.potapczuk.events.service.EventService;

public class EventControllerTest extends AbstractControllerTest {
	
	private Page<Event> eventsPage;
	
	private EventService eventService;
	
	private final String EVENT_NAME = "Event name";
	private final String EVENT_DESCRIPTION = "Event description";
	private final Date EVENT_DATE = new Date();
	private final Double EVENT_PRICE = 50.0;
	
	public Event createTestEvent() {
		Event event = new Event();
		event.setId(1l);
		event.setName(EVENT_NAME);
		event.setDescription(EVENT_DESCRIPTION);
		event.setEventDate(EVENT_DATE);
		event.setPrice(EVENT_PRICE);
		event.setCreatedAt(EVENT_DATE);
		event.setUser(null);
		
		return event;
	}
	
	protected void assertTestEvent(Event event) {
		assertNotNull(event);
		assertEquals(event.getName(), EVENT_NAME);
		assertEquals(event.getDescription(), EVENT_DESCRIPTION);
		assertEquals(event.getEventDate(), EVENT_DATE);
		assertEquals(event.getCreatedAt(), EVENT_DATE);
		assertEquals(event.getPrice(), EVENT_PRICE);
	}

	@Before
	public void initEvents() {
		// Initialize list of events for mocked EventService
		Event event = createTestEvent();
		
		List<Event> events = new ArrayList<Event>();
		events.add(event);
		
		eventsPage = new PageImpl<Event>(events);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testListAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		when(eventService.findAll(isA(Pageable.class))).thenReturn(eventsPage);
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ExtendedModelMap model = new ExtendedModelMap();
		
		// Act
		String result = eventController.list(model);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_LIST);
		Page<Event> listResult = (Page<Event>) model.get("items");
		assertEquals(1, listResult.getNumberOfElements());
		Event event = listResult.getContent().get(0);
		assertTestEvent(event);
	}
	
	@Test
	public void testViewAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		when(eventService.findOne(isA(Long.class))).thenReturn(eventsPage.getContent().get(0));
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ExtendedModelMap model = new ExtendedModelMap();
		
		// Act
		String result = eventController.view(1l, model);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_VIEW);
		
		Event event = (Event) model.get("item");
		assertTestEvent(event);
	}
	
	@Test
	public void testCreateAction() throws Exception {
		//Arrange
		EventController eventController = new EventController();
		ExtendedModelMap model = new ExtendedModelMap();
		
		// Act
		String result = eventController.create(model);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM);
	}
	
	@Test
	public void testEditAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		when(eventService.findOne(isA(Long.class))).thenReturn(eventsPage.getContent().get(0));
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ExtendedModelMap model = new ExtendedModelMap();
		
		// Act
		String result = eventController.edit(1l, model);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM);
		
		Event event = (Event) model.get("item");
		assertTestEvent(event);
	}
	
	@Test
	public void testSaveEditAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		
		RedirectAttributes redirect = mock(RedirectAttributes.class);
		Flash flashMessage = mock(Flash.class);
		
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ReflectionTestUtils.setField(eventController, "flash",
				flashMessage);
		
		// Act
		String result = eventController.save(eventsPage.getContent().get(0), bindingResult, redirect);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, BaseMapping.REDIRECT + EventMapping.BASE_FOLDER);
		
		verify(eventService, times(1)).save(isA(Event.class));
        verifyNoMoreInteractions(eventService);
        
        verify(flashMessage, times(1)).message(isA(RedirectAttributes.class), isA(String.class));
        verifyNoMoreInteractions(flashMessage);
	}
	
	@Test
	public void testSaveWithErrorAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		
		RedirectAttributes redirect = mock(RedirectAttributes.class);
		Flash flashMessage = mock(Flash.class);
		
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ReflectionTestUtils.setField(eventController, "flash",
				flashMessage);
		
		// Act
		String result = eventController.save(eventsPage.getContent().get(0), bindingResult, redirect);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM);
	}
	
	@Test
	public void testRemoveAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		when(eventService.findOne(isA(Long.class))).thenReturn(eventsPage.getContent().get(0));
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ExtendedModelMap model = new ExtendedModelMap();
		
		// Act
		String result = eventController.remove(1l, model);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, EventMapping.BASE_FOLDER + EventMapping.VIEW_REMOVE);
		
		Event event = (Event) model.get("item");
		assertTestEvent(event);
	}
	
	@Test
	public void testRemovePermAction() throws Exception {
		//Arrange
		eventService = mock(EventService.class);
		
		RedirectAttributes redirect = mock(RedirectAttributes.class);
		Flash flashMessage = mock(Flash.class);
		
		EventController eventController = new EventController();
		ReflectionTestUtils.setField(eventController, "service",
				eventService);
		ReflectionTestUtils.setField(eventController, "flash",
				flashMessage);
		
		// Act
		String result = eventController.removePerm(1l, redirect);
		
		// Assert
		assertNotNull(result);
		assertEquals(result, BaseMapping.REDIRECT + EventMapping.BASE_FOLDER);
		
		verify(eventService, times(1)).delete(isA(Long.class));
        verifyNoMoreInteractions(eventService);
        
        verify(flashMessage, times(1)).message(isA(RedirectAttributes.class), isA(String.class));
        verifyNoMoreInteractions(flashMessage);
	}
}