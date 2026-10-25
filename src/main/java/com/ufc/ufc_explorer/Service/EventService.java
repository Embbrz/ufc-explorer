package com.ufc.ufc_explorer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ufc.ufc_explorer.Entity.Bout;
import com.ufc.ufc_explorer.Entity.Event;
import com.ufc.ufc_explorer.Repository.BoutRepository;
import com.ufc.ufc_explorer.Repository.EventRepository;

@Service
public class EventService {
	private BoutRepository boutRepo;
	private EventRepository eventRepo;
	
	@Autowired
	public EventService(EventRepository ep, BoutRepository bp) {
		this.eventRepo = ep;
		this.boutRepo = bp;
	}
	
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Page<Event> getEvents(Pageable pageable){
		return eventRepo.findAll(pageable);
	}
	
	public Event byId(Long id) {
		return eventRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Sorry! Event ID " + id + " Not Found!"));
	}
	
	public List<Bout> eventCard(Long id){
		
		Event event = this.byId(id);
		
		return boutRepo.findByEventId(id);
	}

}
