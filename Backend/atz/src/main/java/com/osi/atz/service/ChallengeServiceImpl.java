package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.ChallengeDto;
import com.osi.atz.model.Challenge;
import com.osi.atz.model.Company;
import com.osi.atz.model.User;
import com.osi.atz.repository.ChallengeRepository;
import com.osi.atz.repository.CompanyRepository;
import com.osi.atz.repository.UserRepository;

@Service
public class ChallengeServiceImpl implements IChallengeService {
	
	private UserRepository userRepository;
	private CompanyRepository companyRepository;
	private ChallengeRepository challengeRepository;

	public ChallengeServiceImpl(UserRepository userRepository, CompanyRepository companyRepository, ChallengeRepository challengeRepository) {
		this.userRepository = userRepository;
		this.companyRepository = companyRepository;
		this.challengeRepository = challengeRepository;
	}

	@Override
	public String createChallenge(ChallengeDto challengeDto) {
		String email = "abhi2@abc.com";
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		Company company = companyRepository.findByUser(user);
		if(company == null) {
			throw new RuntimeException("Company is not associated with any user");
		}
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
	public String updateChallenge(ChallengeDto challengeDto) {
		Challenge existingChallenge = challengeRepository.findById(challengeDto.getChallengeId())
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
		ChallengeDto challengeDto = convertChallengeToChallengeDto(existingChallenge);
		
		return challengeDto;
	}

	private ChallengeDto convertChallengeToChallengeDto(Challenge challenge) {
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
		challengeRepository.delete(existingChallenge);
		return "Challenge deleted successfully";
	}

}
