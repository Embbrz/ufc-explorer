package com.ufc.ufc_explorer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bouts")
@Data
@NoArgsConstructor
public class Bout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "fighter_a_id", nullable = false)
	private Fighter fighterA;
	
	@ManyToOne
	@JoinColumn(name = "fighter_b_id", nullable = false)
	private Fighter fighterB;
	
	@ManyToOne
	@JoinColumn(name = "winner_id")
	private Fighter winner;
	
	@Column(name = "weight_class", nullable = false)
	private String weightClass;
	
	@Column(name = "is_title_fight")
	private boolean isTitleFight = false;
	
	@Column(name = "method_of_victory")
	private String methodOfVictory;

}
