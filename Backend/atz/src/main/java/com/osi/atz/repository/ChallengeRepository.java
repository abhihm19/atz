package com.osi.atz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.atz.model.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
