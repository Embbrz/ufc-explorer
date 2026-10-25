package com.ufc.ufc_explorer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jdi.event.Event;
import com.ufc.ufc_explorer.Service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	private EventService eventService;
	
	@Autowired
	public EventController(EventService es) {
		this.eventService = es;
	}
	
	
	@PostMapping("/api/create")
	public Event createEvent(@RequestBody Event event) {
		return this.eventService.createEvent(event);
	}

}
