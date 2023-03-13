package com.osi.atz.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
	
	@Id
	private int challengeId;
	private int companyId;
	private int challengeDuration;
	private Date startDateTime;
	private Date endDateTime;
	

}
