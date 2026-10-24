package com.ufc.ufc_explorer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
public record ChangeRequest(
		@JsonProperty("fighterID") Long id,
		@JsonProperty("firstNameUpdate") String firstName,
		@JsonProperty("lastNameUpdate") String lastName,
		@JsonProperty("nicknameUpdate") String nickName,
		@JsonProperty("weightClassUpdate") String weightClass,
		@JsonProperty("winsUpdate") Integer wins,
		@JsonProperty("lossesUpdate") Integer losses,
		@JsonProperty("drawsUpdate") Integer draws,
		@JsonProperty("strikingAccuracyUpdate") BigDecimal strikingAccuracy,
		@JsonProperty("reachInchesUpdate") BigDecimal reachInches
		
		
		
		) {

}
