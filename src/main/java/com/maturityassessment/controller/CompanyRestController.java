package com.maturityassessment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.service.CompanyService;

/**
 * @author nitin.jaiswal
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/company")
public class CompanyRestController {

	Logger log = LoggerFactory.getLogger(CompanyRestController.class);

	@Autowired
	private CompanyService companyService;

	@GetMapping("/get")
	public ResponseEntity<?> getCompanyDetails() {
		try {
			List<CompanyBean> companyBean = companyService.getCompanyDetails();
			if(companyBean!=null && !companyBean.isEmpty()) {
				return new ResponseEntity<>(companyBean, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("There is no record", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/get/{email}")
	public ResponseEntity<?> getCompanyDetailsByEmail(@PathVariable("email") String email) {
		try {
			if (email != null && !email.isEmpty()) {
				CompanyBean companyBean = companyService.getCompanyDetailsByEmail(email);
				if (companyBean != null) {
					return new ResponseEntity<>(companyBean, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Email id is not valid", HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<>("Please provide email id", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveCompanyData(@RequestBody CompanyBean companyBean) {
		ResponseEntity<String> response = null;
		try {
			boolean companyEmail = companyService.findByCompanyEmail(companyBean.getEmail());
			if (companyEmail) {
				response = new ResponseEntity<>("Email id should be unique : " + companyBean.getEmail(), HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(
						"Company Details added " + companyService.saveCompanyDetails(companyBean), HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		return response;
	}
}
