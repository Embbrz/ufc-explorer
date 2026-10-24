package com.ufc.ufc_explorer.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ufc.ufc_explorer.Entity.Fighter;
import com.ufc.ufc_explorer.Repository.FigtherRepository;

@Service
public class FighterService {

	private FigtherRepository fighterRepo;
	
	@Autowired
	public FighterService(FigtherRepository f) {
		this.fighterRepo = f;
	}
	
	public Page<Fighter> getFighter(String w, Pageable pageable){
		if (w == null) {
			return fighterRepo.findAll(pageable);
		}
		return fighterRepo.findAllByweightClass(w, pageable);
		
			
		
		
	}
	
	public Fighter byId(Long id) {
		return fighterRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Fighter with the ID " + id + " Not Found"));
	}

}
