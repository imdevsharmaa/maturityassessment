package com.maturityassessment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_SIZE")
public class CompanySize implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_size_seq")
	@SequenceGenerator(name = "company_size_seq", sequenceName = "company_size_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "COMPANY_SIZE_ID", unique = true, nullable = false)
	private Integer companySizeId;

	@Column(name = "SIZE_DISPLAY_VALUE")
	private String sizedisplayvalue;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	public CompanySize() {
	}

	public CompanySize(Integer companySizeId, String sizedisplayvalue, String description, Boolean activeFlag) {
		this.companySizeId = companySizeId;
		this.sizedisplayvalue = sizedisplayvalue;
		this.description = description;
		this.activeFlag = activeFlag;
	}

	public Integer getCompanySizeId() {
		return companySizeId;
	}

	public void setCompanySizeId(Integer companySizeId) {
		this.companySizeId = companySizeId;
	}

	public String getSizedisplayvalue() {
		return sizedisplayvalue;
	}

	public void setSizedisplayvalue(String sizedisplayvalue) {
		this.sizedisplayvalue = sizedisplayvalue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
