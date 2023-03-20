package com.osi.atz.service;

import com.osi.atz.dto.CompanyDto;

public interface ICompanyService {
	
	String updateCompany(CompanyDto companyDto, String username);
	CompanyDto viewCompany(String username);
	String deleteCompany(String username);

}
