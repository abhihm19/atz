package com.osi.atz.service;

import java.util.List;

import com.osi.atz.dto.ChallengeDto;

public interface IChallengeService {
	
	String createChallenge(ChallengeDto challengeDto , int companyId);
	String updateChallenge(ChallengeDto challengeDto, int challengeId);
	ChallengeDto viewChallenge(int challengeId);
	String deleteChallenge(int challengeId);
	List<ChallengeDto> getChallenges(int companyId);

}
