package com.ufc.ufc_explorer.dto;

import com.ufc.ufc_explorer.Entity.Fighter;

public record HeadToHeadRespone(Fighter fighterA,
		Fighter fighterB,
		String reachAdvantageSummary,
		String strikingComparison,
		String weightClassMatchup) {


}
