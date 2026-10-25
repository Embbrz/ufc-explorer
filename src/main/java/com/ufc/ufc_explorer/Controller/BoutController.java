package com.ufc.ufc_explorer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.ufc_explorer.Entity.Bout;
import com.ufc.ufc_explorer.Service.BoutService;
import com.ufc.ufc_explorer.dto.ResultRequest;

@RestController
@RequestMapping("/api/bouts")
public class BoutController {
	
	private BoutService boutService;
	
	@Autowired
	public BoutController(BoutService boutService) {
		this.boutService = boutService;
	}
	
	
	@PostMapping("/{boutId}/result")
	public Bout recordFightResult(@PathVariable Long boutId, ResultRequest result) {
		return this.boutService.recordFightResult(boutId, result);
	}
	

}
