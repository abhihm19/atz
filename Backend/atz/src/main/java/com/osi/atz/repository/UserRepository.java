package com.osi.atz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.atz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}