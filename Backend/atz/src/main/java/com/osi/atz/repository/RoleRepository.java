package com.osi.atz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.atz.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRoleName(String roleName);
}
