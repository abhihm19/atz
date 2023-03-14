package com.osi.atz.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "challenges")
public class Challenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int challengeId;
	private String challengeName;
	private int challengeDurationInMinutes;
	private Date startDateTime;
	private Date endDateTime;
	
	
	

}
