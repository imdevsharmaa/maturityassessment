package com.maturityassessment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_RESPONSE")
public class CompanyResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyResponse_seq")
	@SequenceGenerator(name = "companyResponse_seq", sequenceName = "companyResponse_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "COMPANY_RESPONSE_ID", unique = true, nullable = false)
	private Integer companyResponseId;

	@OneToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	@OneToOne
	@JoinColumn(name = "QUESTIONS_ID")
	private Questions questions;
	@OneToOne
	@JoinColumn(name = "OPTIONS_ID")
	private Options options;

}
