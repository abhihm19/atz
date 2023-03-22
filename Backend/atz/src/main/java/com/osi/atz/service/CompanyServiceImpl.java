package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.CompanyDto;
import com.osi.atz.model.Company;
import com.osi.atz.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public String updateCompany(CompanyDto companyDto, int companyId) {		
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		company.setCompanyName(companyDto.getCompanyName());
		company.setAboutCompany(companyDto.getAboutCompany());
		
		companyRepository.save(company);		
		return "Company details saved";

	}

	@Override
	public CompanyDto viewCompany(int companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		CompanyDto companyDto = new CompanyDto();
		companyDto.setCompanyName(company.getCompanyName());
		companyDto.setAboutCompany(company.getAboutCompany());
		return companyDto;
	}

	@Override
	public String deleteCompany(int companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		companyRepository.delete(company);
		
		return "Company deleted successfully";
	}

}
