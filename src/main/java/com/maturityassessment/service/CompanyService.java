package com.maturityassessment.service;

import java.util.List;
import java.util.Optional;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.model.Company;

public interface CompanyService {

	Integer saveCompanyDetails(CompanyBean companyBean);

	Optional<Company> getcompanyById(Integer companyId);

	Integer addCompany(Company prepareCompanyDTO);

	List<Company> getAllCompanyDetails();

	List<Company> findByCompanyName(String companyName);

	String deleteAllCompanies();

	String deleteCompanyById(Integer companyId);

	boolean isCompanyExist(long company_id);

	CompanyBean getCompanyBeanByCompanyId(Integer companyId);

	//List<Integer> getCompanySizeDetails();

}
