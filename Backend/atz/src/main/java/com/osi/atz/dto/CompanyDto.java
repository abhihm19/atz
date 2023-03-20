package com.osi.atz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	private int companyId;
	private String companyName;
	private String aboutCompany;
	private long userId;	

}
