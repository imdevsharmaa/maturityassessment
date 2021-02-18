package com.maturityassessment.beans;

public class OptionsBean {

	private String option;
	private Integer weightage;

	public OptionsBean() {
	}

	public OptionsBean(String option, Integer weightage) {
		this.option = option;
		this.weightage = weightage;
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

}
