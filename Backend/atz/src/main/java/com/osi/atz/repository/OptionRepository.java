package com.osi.atz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.atz.model.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {

}
