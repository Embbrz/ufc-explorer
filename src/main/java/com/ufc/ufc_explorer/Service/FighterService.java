package com.ufc.ufc_explorer.Service;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ufc.ufc_explorer.Entity.Fighter;
import com.ufc.ufc_explorer.Repository.FigtherRepository;
import com.ufc.ufc_explorer.dto.HeadToHeadRespone;

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
		if ((wins != null) && (wins >= 0)) {
			fighter.setWins(wins);
		}
		if ((losses != null) && (losses >= 0)) {
			fighter.setLosses(losses);
		}
		if ((draws != null) && (draws >= 0)) {
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
	
	public HeadToHeadRespone compare(Long fighterA, Long fighterB){
		Fighter fighter1 = this.byId(fighterA);
		Fighter fighter2 = this.byId(fighterB);
		String name1 = fighter1.getFirstName() + " " + fighter1.getLastName();
		String name2 = fighter2.getFirstName() + " " + fighter2.getLastName();
		String reachA = name1 +" has an equal reach to " + name2;
		String strikingA = name1 +" has an equals striking accuracy to " + name2;
		String weightMatchup = "Equal-weight comparison (" + fighter1.getWeightClass() +" vs " + fighter2.getWeightClass() +")";
		int reachComp = fighter1.getReachInches().compareTo(fighter2.getReachInches());
		int strikingComp = fighter1.getStrikingAccuracy().compareTo(fighter2.getStrikingAccuracy());
		if (reachComp > 0) {
			reachA = name1 +" has a reach advantage over " + name2;
		}
		if (reachComp < 0) {
			reachA = name2 + " has a reach advantage over " + name1;
		}
		if (strikingComp > 0) {
			strikingA = name1 + " has a higher striking accuracy over " + name2;
		}
		if (strikingComp < 0) {
			strikingA = name2 + " has a higher striking accuracy over " + name1;
		}
		if (!(fighter1.getWeightClass().toLowerCase().equalsIgnoreCase(fighter2.getWeightClass().toLowerCase()))) {
			weightMatchup = "Cross-weight comparison (" + fighter1.getWeightClass() +" vs " +fighter2.getWeightClass() +")";
		}
		
		return new HeadToHeadRespone(fighter1, fighter2, reachA, strikingA, weightMatchup);
		
		
		
	}

}
