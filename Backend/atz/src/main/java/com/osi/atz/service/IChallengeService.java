package com.osi.atz.service;

import com.osi.atz.dto.ChallengeDto;

public interface IChallengeService {
	
	String createChallenge(ChallengeDto challengeDto);
	String updateChallenge(ChallengeDto challengeDto);
	ChallengeDto viewChallenge(int challengeId);
	String deleteChallenge(int challengeId);

}
