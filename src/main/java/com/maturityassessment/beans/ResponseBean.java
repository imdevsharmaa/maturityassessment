package com.maturityassessment.beans;

import org.springframework.http.HttpStatus;

public class ResponseBean {

	private String body;
	private HttpStatus status;

	public ResponseBean() {
	}

	public ResponseBean(String body, HttpStatus status) {
		this.body = body;
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
