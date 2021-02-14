package com.maturityassessment.beans;

public class OptionsBean {

	private String option;
	private String weightage;

	public OptionsBean() {
	}

	public OptionsBean(String option, String weightage) {
		this.option = option;
		this.weightage = weightage;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

}
