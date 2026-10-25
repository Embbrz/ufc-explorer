package com.ufc.ufc_explorer.Service;

import org.springframework.stereotype.Service;

import com.ufc.ufc_explorer.Entity.Bout;
import com.ufc.ufc_explorer.Entity.Fighter;
import com.ufc.ufc_explorer.Repository.BoutRepository;
import com.ufc.ufc_explorer.Repository.FigtherRepository;
import com.ufc.ufc_explorer.dto.ResultRequest;

import jakarta.transaction.Transactional;

@Service
public class BoutService {
	
	private BoutRepository boutRepo;
	private FigtherRepository fightRepo;
	
	public BoutService(BoutRepository bp, FigtherRepository pp) {
		this.boutRepo = bp;
		this.fightRepo = pp;
	}
	
	@Transactional
	public Bout recordFightResult(Long id, ResultRequest result) {
		Bout bout = boutRepo.findById(id).orElseThrow(() -> new RuntimeException("Bout ID " + id +" Not Found!"));
		
		Long winnerID = result.winnerId();
		
		Long fighterAid = bout.getFighterA().getId();
		Long fighterBid = bout.getFighterB().getId();
		
		Fighter winner;
		Fighter loser;
		
		if (winnerID.equals(fighterBid)) {
			winner = bout.getFighterB();
			loser = bout.getFighterA();
			
			
		}
		else if (winnerID.equals(fighterAid)) {
			winner = bout.getFighterA();
			loser = bout.getFighterB();
			
		}
		else {
			throw new RuntimeException("Winner ID does not Match Anyone in Bout!: " + winnerID);
		}
		
		winner.setWins(winner.getWins() + 1);
		loser.setLosses(loser.getLosses() + 1);
		fightRepo.save(winner);
		fightRepo.save(loser);
		
		bout.setWinner(winner);
		bout.setMethodOfVictory(result.methodOfVictory());
		
		return boutRepo.save(bout);
		
	}

}
