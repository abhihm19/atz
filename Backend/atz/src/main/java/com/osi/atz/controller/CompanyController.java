package com.osi.atz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.atz.dto.ApiResponse;
import com.osi.atz.dto.CompanyDto;
import com.osi.atz.service.ICompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1/{username}/company")
public class CompanyController {
	
	private ICompanyService companyService;

	public CompanyController(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PutMapping("/{companyId}")
    public ResponseEntity<ApiResponse> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable int companyId) {
		String output = companyService.updateCompany(companyDto, companyId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> viewCompany(@PathVariable int companyId) {
		CompanyDto companyDto = companyService.viewCompany(companyId);
    	return ResponseEntity.ok().body(companyDto);	
	}
	
	@DeleteMapping("/{companyId}")
    public ResponseEntity<ApiResponse> deleteCompany(@PathVariable int companyId) {
		String output = companyService.deleteCompany(companyId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}

}
