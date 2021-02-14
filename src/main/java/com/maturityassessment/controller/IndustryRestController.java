package com.maturityassessment.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maturityassessment.service.IndustryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/industry")
public class IndustryRestController {

	@Autowired
	private IndustryService industryService;

	@GetMapping("/get/all")
	public Set<String> getAllIndustryiesType() {

		return industryService.getAllIndustryiesType();
	}

}
