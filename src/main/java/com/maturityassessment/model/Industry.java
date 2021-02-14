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
@Table(name = "INDUSTRY")
public class Industry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "industry_seq")
	@SequenceGenerator(name = "industry_seq", sequenceName = "industry_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "INDUSTRY_ID", unique = true, nullable = false)
	private Integer industryId;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	public Industry() {
	}

	public Industry(Integer industryId, String name, String description, Boolean activeFlag) {
		this.industryId = industryId;
		this.name = name;
		this.description = description;
		this.activeFlag = activeFlag;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
