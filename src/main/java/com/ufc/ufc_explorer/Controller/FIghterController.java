package com.ufc.ufc_explorer.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/api/Getfighters")
	public Page<Fighter> getFighters(
			@RequestParam(required = false) String weightClass,
			@PageableDefault(page = 0, size = 10, sort = "firstName") Pageable pageable){
		return this.fighterService.getFighter(weightClass, pageable);
		
		
	}
	


}
