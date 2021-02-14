package com.maturityassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maturityassessment.beans.CategoriesBean;
import com.maturityassessment.beans.ResponseBean;
import com.maturityassessment.service.CategoriesService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categories")
public class CategoriesRestController {

	@Autowired
	private CategoriesService categoriesService;

	@PostMapping("/add")
	public ResponseEntity<?> addCategories(@RequestBody CategoriesBean categoriesBean) {

		ResponseEntity<String> response = null;
		try {
			ResponseBean responseBean = categoriesService.saveCategories(categoriesBean);
			response = new ResponseEntity<>(responseBean.getBody(), responseBean.getStatus());
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
