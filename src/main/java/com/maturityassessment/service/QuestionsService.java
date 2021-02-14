package com.maturityassessment.service;

import java.util.List;

import com.maturityassessment.beans.QuestionBean;
import com.maturityassessment.beans.ResponseBean;

public interface QuestionsService {

	public ResponseBean saveQuestions(QuestionBean questionBean);

	public QuestionBean getQuestionBeanById(Integer id);

	public List<QuestionBean> getAllQuestionBeans();

}
