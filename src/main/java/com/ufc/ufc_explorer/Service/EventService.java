package com.ufc.ufc_explorer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sun.jdi.event.Event;
import com.ufc.ufc_explorer.Repository.EventRepository;

@Service
public class EventService {
	
	private EventRepository eventRepo;
	
	@Autowired
	public EventService(EventRepository ep) {
		this.eventRepo = ep;
	}
	
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Page<Event> getEvents(Pageable pageable){
		return eventRepo.findAll(pageable);
	}

}
