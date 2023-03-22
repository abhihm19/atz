package com.osi.atz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto {
	
	private long userDetailId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String currentLocation;
	private String Gender;
	private String universityName;
	private int graduationYear;
	private String degree;
	private int numberOfAttempts;

}
