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

import com.maturityassessment.beans.QuestionBean;
import com.maturityassessment.beans.RequestValidation;
import com.maturityassessment.beans.ResponseBean;
import com.maturityassessment.service.QuestionsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/question")
public class QuestionRestController {

	Logger log = LoggerFactory.getLogger(QuestionRestController.class);

	@Autowired
	private QuestionsService questionsService;

	@PostMapping("/add")
	public ResponseEntity<?> addQuestion(@RequestBody QuestionBean questionBean) {

		ResponseEntity<String> responseData = null;
		RequestValidation requestValidation = this.validateQuestionBean(questionBean);

		try {

			ResponseBean responseBean = questionsService.saveQuestions(questionBean);
			if (!requestValidation.getIsInValid()) {
				responseData = new ResponseEntity<>(responseBean.getBody(), responseBean.getStatus());
			} else {
				responseData = new ResponseEntity<>(requestValidation.getResponse(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responseData = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return responseData;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllQuestions() {
		ResponseEntity<?> response = null;
		try {
			List<QuestionBean> questions = questionsService.getAllQuestionBeans();
			if (questions == null || questions.isEmpty()) {
				response = new ResponseEntity<>("No Questions Found", HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(questions, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("/get/{qId}")
	public ResponseEntity<?> getQuestionById(@PathVariable("qId") Integer qId) {
		ResponseEntity<?> response = null;
		try {
			QuestionBean questionBean = questionsService.getQuestionBeanById(qId);

			if (questionBean == null) {
				response = new ResponseEntity<>("No Questions Found", HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(questionBean, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	private RequestValidation validateQuestionBean(QuestionBean questionBean) {
		RequestValidation validation = new RequestValidation(Boolean.FALSE, "Valid request");

		if (questionBean != null) {
			if (questionBean.getNoOfOptions() != questionBean.getOptionsBean().size()) {
				validation = new RequestValidation(Boolean.TRUE, "Number of options and option beans must be same.");
			}
			if (questionBean.getCategoriesId() == null) {
				validation = new RequestValidation(Boolean.TRUE, "Please provide Categories Id.");
			}
		} else {
			validation = new RequestValidation(Boolean.TRUE, "QuestionBean is null. Please check.");
		}

		return validation;
	}

}
