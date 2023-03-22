package com.osi.atz.service;

import com.osi.atz.dto.CompanyDto;

public interface ICompanyService {
	
	String updateCompany(CompanyDto companyDto, int companyId);
	CompanyDto viewCompany(int companyId);
	String deleteCompany(int companyId);

}
