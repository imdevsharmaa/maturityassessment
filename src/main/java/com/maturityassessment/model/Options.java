package com.maturityassessment.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OPTIONS")
public class Options implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "options_seq")
	@SequenceGenerator(name = "options_seq", sequenceName = "options_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "OPTIONS_ID", unique = true, nullable = false)
	private Integer optionsId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTIONS_ID")
	private Questions questions;

	@Column(name = "Q_OPTION")
	private String option;
	@Column(name = "WEIGHTAGE")
	private Integer weightage;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	public Options() {
	}

	public Options(Integer optionsId, Questions questions, String option, Integer weightage, Boolean activeFlag) {
		this.optionsId = optionsId;
		this.questions = questions;
		this.option = option;
		this.weightage = weightage;
		this.activeFlag = activeFlag;
	}

	public Integer getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(Integer optionsId) {
		this.optionsId = optionsId;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Integer getWeightage() {
		return weightage;
	}

	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
