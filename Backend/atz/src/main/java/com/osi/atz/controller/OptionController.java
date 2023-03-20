package com.osi.atz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.atz.dto.ApiResponse;
import com.osi.atz.dto.OptionDto;
import com.osi.atz.service.IOptionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1/{username}/company/{companyId}/challenge/{challengeId}/question/{questionId}/option")
public class OptionController {
	
	private IOptionService optionService;

	public OptionController(IOptionService optionService) {
		this.optionService = optionService;
	}
	
	@PostMapping()
    public ResponseEntity<ApiResponse> createOption(@RequestBody OptionDto optionDto,@PathVariable int questionId) {
		String output = optionService.createOption(optionDto, questionId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@PutMapping("/{optionId}")
    public ResponseEntity<ApiResponse> updateOption(@RequestBody OptionDto optionDto, @PathVariable int optionId) {
		String output = optionService.updateOption(optionDto, optionId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@GetMapping("/{optionId}")
    public ResponseEntity<OptionDto> viewOption(@PathVariable int optionId) {
		OptionDto optionDto = optionService.viewOption(optionId);
    	return ResponseEntity.ok().body(optionDto);	
	}
	
	@GetMapping()
    public ResponseEntity<List<OptionDto>> getOptions(@PathVariable int questionId) {
		List<OptionDto> optionDtos = optionService.getOptions(questionId);
    	return ResponseEntity.ok().body(optionDtos);	
	}
	
	@DeleteMapping("/{optionId}")
    public ResponseEntity<ApiResponse> deleteOption(@PathVariable int optionId) {
		String output = optionService.deleteOption(optionId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	

}
