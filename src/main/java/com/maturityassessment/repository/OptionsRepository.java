package com.maturityassessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maturityassessment.model.Questions;
import com.maturityassessment.model.Options;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer>{
	
	List<Options> findByQuestions(Questions questions);

}
