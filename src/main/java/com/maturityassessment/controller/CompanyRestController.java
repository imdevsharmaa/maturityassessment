package com.maturityassessment.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.beans.QuestionResponseBean;
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
		Integer companyId = 1;
		CompanyBean companyBean = companyService.getCompanyBeanByCompanyId(companyId);
		if (companyBean == null) {
			companyBean = new CompanyBean();
			companyBean.setCompanyName("Test Company");
			companyBean.setEmail("test@test.com");

			companyBean.setFirstName("Test F");
			companyBean.setLastName("Test L");
			companyBean.setIndustryId(1);
			companyBean.setPhone("9494767991");
			companyBean.setPrivacyPolicy(true);
			companyBean.setScheduler(true);
			companyBean.setSizeId(1);

			List<QuestionResponseBean> questionBeans = new ArrayList<QuestionResponseBean>();
			QuestionResponseBean questionBean = new QuestionResponseBean(1, true, 1);
			QuestionResponseBean questionBean1 = new QuestionResponseBean(2, true, 1);

			questionBeans.add(questionBean);
			questionBeans.add(questionBean1);
			companyBean.setQuestionBeans(questionBeans);
		}
		return new ResponseEntity<>(companyBean, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveCompanyData(@RequestBody CompanyBean companyBean) {
		ResponseEntity<String> response = null;
		try {
			response = new ResponseEntity<>("Company Details added " + companyService.saveCompanyDetails(companyBean),
					HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		return response;
	}
	
	
	/*
	 * @GetMapping("/getcompanysizedetails") public List<Integer>
	 * getCompanySizeDetails() { return companyService.getCompanySizeDetails(); }
	 */
	 
	
}
