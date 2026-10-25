package com.ufc.ufc_explorer.dto;

public record ResultRequest(Long winnerId,
		String methodOfVictory,
		int round,
		String time) {

}
