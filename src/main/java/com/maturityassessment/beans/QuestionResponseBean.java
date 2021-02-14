package com.maturityassessment.beans;

public class QuestionResponseBean {

	private Integer questionId;
	private Boolean responseFlag;
	private Integer selectedOption;
	
	public QuestionResponseBean() {
	}

	public QuestionResponseBean(Integer questionId, Boolean responseFlag, Integer selectedOption) {
		this.questionId = questionId;
		this.responseFlag = responseFlag;
		this.selectedOption = selectedOption;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Boolean getResponseFlag() {
		return responseFlag;
	}

	public void setResponseFlag(Boolean responseFlag) {
		this.responseFlag = responseFlag;
	}

	public Integer getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}

}
