package com.ufc.ufc_explorer.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fighters")
@Data
@NoArgsConstructor
public class Fighter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "nickname")
	private String nickName;
	
	@Column(name = "weight_class", nullable = false)
	private String weightClass;
	
	@Column(name = "wins")
	private Integer wins = 0;
	
	@Column(name = "losses")
	private Integer losses = 0;
	
	@Column(name = "draws")
	private Integer draws = 0;
	
	@Column(name = "striking_accuracy")
	private BigDecimal strikingAccuracy;
	
	@Column(name = "reach_inches")
	private BigDecimal reachInches;
	

}
