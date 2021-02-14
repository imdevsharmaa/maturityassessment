package com.maturityassessment.beans;

public class RequestValidation {

	private Boolean isInValid;
	private String response;

	public RequestValidation() {
	}

	public RequestValidation(Boolean isInValid, String response) {
		this.isInValid = isInValid;
		this.response = response;
	}

	public Boolean getIsInValid() {
		return isInValid;
	}

	public void setIsInValid(Boolean isInValid) {
		this.isInValid = isInValid;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
