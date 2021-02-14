package com.maturityassessment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
	@SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "CATEGORIES_ID", unique = true, nullable = false)
	private Integer categoriesId;

	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	@OneToMany(mappedBy = "categories")
	private Set<Questions> questions;

	public Categories() {
	}

	public Categories(Integer categoriesId, String category, String description, Boolean activeFlag,
			Set<Questions> questions) {
		this.categoriesId = categoriesId;
		this.category = category;
		this.description = description;
		this.activeFlag = activeFlag;
		this.questions = questions;
	}

	public Integer getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(Integer categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

}
