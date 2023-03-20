package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.CompanyDto;
import com.osi.atz.model.Company;
import com.osi.atz.model.User;
import com.osi.atz.repository.CompanyRepository;
import com.osi.atz.repository.UserRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
	private CompanyRepository companyRepository;
	private UserRepository userRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
		this.companyRepository = companyRepository;
		this.userRepository = userRepository;
	}

	@Override
	public String updateCompany(CompanyDto companyDto, String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
		Company company = companyRepository.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		company.setCompanyName(companyDto.getCompanyName());
		company.setAboutCompany(companyDto.getAboutCompany());
		
		companyRepository.save(company);		
		return "Company details saved";

	}

	@Override
	public CompanyDto viewCompany(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
		Company company = companyRepository.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		CompanyDto companyDto = new CompanyDto();
		companyDto.setCompanyName(company.getCompanyName());
		companyDto.setAboutCompany(company.getAboutCompany());
		return companyDto;
	}

	@Override
	public String deleteCompany(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
		Company company = companyRepository.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		companyRepository.delete(company);
		
		return "Company deleted successfully";
	}

}
