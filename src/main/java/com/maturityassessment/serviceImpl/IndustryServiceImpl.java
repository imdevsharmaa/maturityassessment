package com.maturityassessment.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maturityassessment.repository.IndustryRepository;
import com.maturityassessment.service.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {
	@Autowired
	private IndustryRepository industryRepository;

	@Override
	public Set<String> getAllIndustryiesType() {
		return industryRepository.getIndustiesTypes();
	}

}
