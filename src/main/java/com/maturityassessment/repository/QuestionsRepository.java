package com.maturityassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maturityassessment.model.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

}
