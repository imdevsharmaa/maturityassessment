package com.maturityassessment.beans;

public class CategoriesBean {

	private Integer categoriesId;
	private String category;
	private String description;
	private Boolean activeFlag;

	public CategoriesBean() {
	}

	public CategoriesBean(Integer categoriesId, String category, String description, Boolean activeFlag) {
		this.categoriesId = categoriesId;
		this.category = category;
		this.description = description;
		this.activeFlag = activeFlag;
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

	public Integer getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(Integer categoriesId) {
		this.categoriesId = categoriesId;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
