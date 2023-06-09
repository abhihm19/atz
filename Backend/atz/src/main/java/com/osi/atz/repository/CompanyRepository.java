package com.osi.atz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.atz.model.Company;
import com.osi.atz.model.User;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Optional<Company> findByUser(User user);
}
