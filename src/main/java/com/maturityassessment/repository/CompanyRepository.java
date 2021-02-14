package com.maturityassessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maturityassessment.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	List<Company> findByCompanyName(String companyName);
	
	/*
	 * @Query("SELECT company_size_id FROM Company") List<Integer>
	 * getCompanySizeDetails();
	 */

}
