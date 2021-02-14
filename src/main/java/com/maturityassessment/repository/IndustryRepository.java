package com.maturityassessment.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maturityassessment.model.Industry;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Integer> {

	@Query("SELECT name FROM Industry")
	Set<String> getIndustiesTypes();

}
