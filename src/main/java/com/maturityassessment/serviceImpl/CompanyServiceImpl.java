package com.maturityassessment.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.model.Company;
import com.maturityassessment.repository.CompanyRepository;
import com.maturityassessment.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Integer saveCompanyDetails(CompanyBean companyBean) {
		
		Company company = new Company();
		company.setActiveFlag(Boolean.TRUE);
		company.setCompanyName("Test Company");
		company.setEmail("test@test.com");
		company.setPhone("9494767991");
		company.setFirstName("Test F");
		company.setLastName("Test L");
		company.setPrivacyPolicy(Boolean.TRUE);
		company.setScheduleCall(Boolean.TRUE);
		
		return companyRepository.save(company).getCompanyId();
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Optional<Company> getcompanyById(Integer companyId) {
		// TODO Auto-generated method stub
		return companyRepository.findById(companyId);
	}

	@Override
	public Integer addCompany(Company company) {
		// TODO Auto-generated method stub

		return companyRepository.save(company).getCompanyId();

	}

	@Override
	public boolean isCompanyExist(long company_id) {
		// TODO Auto-generated method stub
		return companyRepository.existsById((int) company_id);
	}

	@Override
	public String deleteAllCompanies() {
		// TODO Auto-generated method stub
		long emloyeesCount = getCompaniesCount();
		if (emloyeesCount > 0) {
			companyRepository.deleteAll();
			return emloyeesCount + " Company deleted successfully";
		}
		return " No employees found...";
	}

	public long getCompaniesCount() {
		return companyRepository.count();
	}

	@Override
	public String deleteCompanyById(Integer companyId) {
		// TODO Auto-generated method stub
		if (isCompanyExist(companyId)) {
			companyRepository.deleteById(companyId);
			return companyId + " Company deleted successfully";
		}
		return companyId + " No company found...";
	}

	@Override
	public List<Company> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyName(companyName);
	}

	@Override
	public CompanyBean getCompanyBeanByCompanyId(Integer companyId) {
		
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * @Override public List<Integer> getCompanySizeDetails() { return
	 * companyRepository.getCompanySizeDetails(); }
	 */
	 

	
}
