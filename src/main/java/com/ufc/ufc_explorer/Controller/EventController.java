package com.ufc.ufc_explorer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.ufc_explorer.Entity.Bout;
import com.ufc.ufc_explorer.Entity.Event;
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
	
	@GetMapping
	public Page<Event> getAllEvents(@PageableDefault(page = 0, size = 10, sort = "id")
	Pageable pageable){
		return this.eventService.getEvents(pageable);
		
	}
	@GetMapping("/{id}")
	public Event getEvent(@PathVariable Long id) {
		return this.eventService.byId(id);
	}
	
	@GetMapping("/{id}/card")
	public List<Bout> eventCard(@PathVariable Long id){
		return this.eventService.eventCard(id);
	}
	
	@PostMapping("/{id}/bouts")
	public List<Bout> addFight(@PathVariable Long id, 
			@RequestBody Bout bout){
		return this.eventService.addFight(id, bout);
	}
	
	@DeleteMapping("/{id}/bouts/delete/{bout}")
	public List<Bout> deleteFight(@PathVariable Long id, 
			@PathVariable Long bout){
		return this.eventService.deleteFight(id, bout);
	}

}
