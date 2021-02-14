package com.maturityassessment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
public class Questions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq")
	@SequenceGenerator(name = "questions_seq", sequenceName = "questions_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "QUESTIONS_ID", unique = true, nullable = false)
	private Integer questionsId;

	@ManyToOne
	@JoinColumn(name = "CATEGORIES_ID")
	private Categories categories;

	@Column(name = "QUESTION")
	private String question;
	@Column(name = "NO_OF_OPTIONS")
	private Integer noOfOptions;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	@OneToMany(mappedBy = "questions")
	private Set<Options> options;

	public Questions() {
	}

	public Questions(Integer questionsId, Categories categories, String question, Integer noOfOptions, Boolean activeFlag,
			Set<Options> options) {
		this.questionsId = questionsId;
		this.categories = categories;
		this.question = question;
		this.noOfOptions = noOfOptions;
		this.activeFlag = activeFlag;
		this.options = options;
	}

	public Integer getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(Integer questionsId) {
		this.questionsId = questionsId;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getNoOfOptions() {
		return noOfOptions;
	}

	public void setNoOfOptions(Integer noOfOptions) {
		this.noOfOptions = noOfOptions;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

}
