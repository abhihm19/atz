package com.osi.atz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.ChallengeDto;
import com.osi.atz.model.Challenge;
import com.osi.atz.model.Company;
import com.osi.atz.repository.ChallengeRepository;
import com.osi.atz.repository.CompanyRepository;

@Service
public class ChallengeServiceImpl implements IChallengeService {
	
	private CompanyRepository companyRepository;
	private ChallengeRepository challengeRepository;

	public ChallengeServiceImpl(CompanyRepository companyRepository, ChallengeRepository challengeRepository) {
		this.companyRepository = companyRepository;
		this.challengeRepository = challengeRepository;
	}

	@Override
	public String createChallenge(ChallengeDto challengeDto, int companyId) {
		
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found"));
		
		Challenge challenge = new Challenge();
		challenge.setChallengeName(challengeDto.getChallengeName());
		challenge.setChallengeDurationInMinutes(challengeDto.getChallengeDurationInMinutes());
		challenge.setStartDateTime(challengeDto.getStartDateTime());
		challenge.setEndDateTime(challengeDto.getEndDateTime());
		challenge.setCompany(company);
		challengeRepository.save(challenge);		
		return "Challenge created successfully";
	}
	
	@Override
	public String updateChallenge(ChallengeDto challengeDto, int challengeId) {
		Challenge existingChallenge = challengeRepository.findById(challengeId)
					.orElseThrow(() -> new RuntimeException("Challenge not found"));
		existingChallenge.setChallengeName(challengeDto.getChallengeName());
		existingChallenge.setChallengeDurationInMinutes(challengeDto.getChallengeDurationInMinutes());
		existingChallenge.setStartDateTime(challengeDto.getStartDateTime());
		existingChallenge.setEndDateTime(challengeDto.getEndDateTime());
		challengeRepository.save(existingChallenge);
		return "Challenge updated successfully";
	}

	

	@Override
	public ChallengeDto viewChallenge(int challengeId) {
		Challenge existingChallenge = challengeRepository.findById(challengeId)
				.orElseThrow(() -> new RuntimeException("Challenge not found"));
		ChallengeDto challengeDto = mapToChallengeDto(existingChallenge);
		
		return challengeDto;
	}

	private ChallengeDto mapToChallengeDto(Challenge challenge) {
		ChallengeDto challengeDto = new ChallengeDto();
		challengeDto.setChallengeName(challenge.getChallengeName());
		challengeDto.setChallengeDurationInMinutes(challenge.getChallengeDurationInMinutes());
		challengeDto.setStartDateTime(challenge.getStartDateTime());
		challengeDto.setEndDateTime(challenge.getEndDateTime());
		challengeDto.setCompanyName(challenge.getCompany().getCompanyName());
		
		return challengeDto;
	}	

	@Override
	public String deleteChallenge(int challengeId) {
		Challenge existingChallenge = challengeRepository.findById(challengeId)
				.orElseThrow(() -> new RuntimeException("Challenge not found"));
		existingChallenge.setCompany(null);
		existingChallenge.setQuestions(null);
		challengeRepository.delete(existingChallenge);
		return "Challenge deleted successfully";
	}

	@Override
	public List<ChallengeDto> getChallenges(int companyId) {
		List<Challenge> challenges = challengeRepository.findAll();
		return challenges.stream().map((challenge) -> mapToChallengeDto(challenge)).collect(Collectors.toList());
	}

}
