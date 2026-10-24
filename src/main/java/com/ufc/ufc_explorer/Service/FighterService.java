package com.ufc.ufc_explorer.Service;



import java.math.BigDecimal;

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
	
	public Fighter deleteById(Long id) {
		Fighter fighter = this.byId(id);
		fighterRepo.deleteById(id);
		return fighter;
	}
	
	public Fighter createFighter(Fighter fighter) {
		return fighterRepo.save(fighter);
	}
	
	public Fighter updateFighter(Long id, String firstName, String lastName,
			String nickName, String weightClass, Integer wins, Integer losses,
			Integer draws, BigDecimal strikingAccuracy, BigDecimal reachInches) {
		
		Fighter fighter = this.byId(id);
		
		if (firstName != null) {
			fighter.setFirstName(firstName);
		}
		if (lastName != null) {
			fighter.setLastName(lastName);
		}
		if (nickName != null) {
			fighter.setNickName(nickName);
		}
		if (weightClass != null) {
			fighter.setWeightClass(weightClass);
		}
		if (wins != null) {
			fighter.setWins(wins);
		}
		if (losses != null) {
			fighter.setLosses(losses);
		}
		if (draws != null) {
			fighter.setDraws(draws);
		}
		if (strikingAccuracy != null) {
			fighter.setStrikingAccuracy(strikingAccuracy);
		}
		if (reachInches != null) {
			fighter.setReachInches(reachInches);
		}
		return fighterRepo.save(fighter);
	}

}
