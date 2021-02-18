package com.maturityassessment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author nitin.jaiswal
 */
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "company_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "COMPANY_ID")
	private Integer companyId;

	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "INDUSTRY_ID")
	private Industry industry;
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "COMPANY_SIZE_ID")
	private CompanySize companySize;

	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "SCHEDULE_CALL")
	private Boolean scheduleCall;
	@Column(name = "PRIVACY_POLICY")
	private Boolean privacyPolicy;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	public Company() {
	}

	public Company(Integer companyId, Industry industry, CompanySize companySize, String companyName, String firstName,
			String lastName, String email, String phone, Boolean scheduleCall, Boolean privacyPolicy,
			Boolean activeFlag) {
		this.companyId = companyId;
		this.industry = industry;
		this.companySize = companySize;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.scheduleCall = scheduleCall;
		this.privacyPolicy = privacyPolicy;
		this.activeFlag = activeFlag;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public CompanySize getCompanySize() {
		return companySize;
	}

	public void setCompanySize(CompanySize companySize) {
		this.companySize = companySize;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Boolean getScheduleCall() {
		return scheduleCall;
	}

	public void setScheduleCall(Boolean scheduleCall) {
		this.scheduleCall = scheduleCall;
	}

	public Boolean getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(Boolean privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
