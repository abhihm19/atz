package com.osi.atz.controller;

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
import com.osi.atz.dto.ChallengeDto;
import com.osi.atz.service.IChallengeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1/company/challenge")
public class ChallengeController {
	
	private IChallengeService challengeService;	
	
	public ChallengeController(IChallengeService challengeService) {
		this.challengeService = challengeService;
	}

	@PostMapping()
    public ResponseEntity<ApiResponse> createChallenge(@RequestBody ChallengeDto challengeDto) {
		String output = challengeService.createChallenge(challengeDto);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@PutMapping()
    public ResponseEntity<ApiResponse> updateChallenge(@RequestBody ChallengeDto challengeDto) {
		String output = challengeService.updateChallenge(challengeDto);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@GetMapping("/{challengeId}")
    public ResponseEntity<ChallengeDto> viewChallenge(@PathVariable int challengeId) {
		System.out.println(challengeId);
		ChallengeDto challengeDto = challengeService.viewChallenge(challengeId);
    	return ResponseEntity.ok().body(challengeDto);	
	}
	
	@DeleteMapping("/{challengeId}")
    public ResponseEntity<ApiResponse> deleteChallenge(@PathVariable int challengeId) {
		String output = challengeService.deleteChallenge(challengeId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}

}
