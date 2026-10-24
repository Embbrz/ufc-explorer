package com.ufc.ufc_explorer.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.ufc_explorer.Entity.Fighter;
import com.ufc.ufc_explorer.Service.FighterService;

@RestController
@RequestMapping("/Fighters")
public class FIghterController {
	
	private FighterService fighterService;
	
	@Autowired
	public FIghterController(FighterService f) {
		this.fighterService = f;
	}
	
	@GetMapping("/api/getfighters")
	public Page<Fighter> getFighters(
			@RequestParam(required = false) String weightClass,
			@PageableDefault(page = 0, size = 10, sort = "firstName") Pageable pageable){
		return this.fighterService.getFighter(weightClass, pageable);
		
		
	}
	
	@GetMapping("/api/fighters/find/{id}")
	public Fighter byId(@PathVariable Long id) {
		return this.fighterService.byId(id);
	}
	
	@DeleteMapping("/api/fighters/delete/{id}")
	public Fighter deletebyId(@PathVariable Long id) {
		return this.fighterService.deleteById(id);
	}
	


}
