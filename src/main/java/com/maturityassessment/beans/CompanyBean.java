package com.maturityassessment.beans;

import java.util.List;

public class CompanyBean {

	private String companyName;
	private Integer industryId;
	private Integer sizeId;
	private String firstName;
	private String lastName;

	private String email;
	private String phone;
	private Boolean scheduler;
	private Boolean privacyPolicy;

	private List<QuestionResponseBean> questionBeans;

	public CompanyBean() {
	}

	public CompanyBean(String companyName, Integer industryId, Integer sizeId, String firstName, String lastName,
			String email, String phone, Boolean scheduler, Boolean privacyPolicy,
			List<QuestionResponseBean> questionBeans) {
		this.companyName = companyName;
		this.industryId = industryId;
		this.sizeId = sizeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.scheduler = scheduler;
		this.privacyPolicy = privacyPolicy;
		this.questionBeans = questionBeans;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getScheduler() {
		return scheduler;
	}

	public void setScheduler(Boolean scheduler) {
		this.scheduler = scheduler;
	}

	public Boolean getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(Boolean privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public List<QuestionResponseBean> getQuestionBeans() {
		return questionBeans;
	}

	public void setQuestionBeans(List<QuestionResponseBean> questionBeans) {
		this.questionBeans = questionBeans;
	}

}
