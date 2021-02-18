package com.maturityassessment.beans;

import java.util.List;

public class QuestionBean {

	private Integer noOfOptions;
	private Integer questionId;
	private String question;
	private List<OptionsBean> optionsBean;
	private Integer categoriesId;

	public QuestionBean() {
	}

	public QuestionBean(Integer noOfOptions, Integer questionId, String question, List<OptionsBean> optionsBean,
			Integer categoriesId) {
		super();
		this.noOfOptions = noOfOptions;
		this.questionId = questionId;
		this.question = question;
		this.optionsBean = optionsBean;
		this.categoriesId = categoriesId;
	}

	public Integer getNoOfOptions() {
		return noOfOptions;
	}

	public void setNoOfOptions(Integer noOfOptions) {
		this.noOfOptions = noOfOptions;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<OptionsBean> getOptionsBean() {
		return optionsBean;
	}

	public void setOptionsBean(List<OptionsBean> optionsBean) {
		this.optionsBean = optionsBean;
	}

	public Integer getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(Integer categoriesId) {
		this.categoriesId = categoriesId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}
