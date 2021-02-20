package com.maturityassessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.beans.QuestionResponseBean;
import com.maturityassessment.model.Company;
import com.maturityassessment.model.CompanySize;
import com.maturityassessment.model.Industry;
import com.maturityassessment.model.Questions;
import com.maturityassessment.repository.CompanyRepository;
import com.maturityassessment.repository.QuestionsRepository;
import com.maturityassessment.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public Integer saveCompanyDetails(CompanyBean companyBean) {
		
		Company company = new Company();
		company.setActiveFlag(Boolean.TRUE);
		company.setCompanyName(companyBean.getCompanyName());
		company.setEmail(companyBean.getEmail());
		company.setPhone(companyBean.getPhone());
		company.setFirstName(companyBean.getFirstName());
		company.setLastName(companyBean.getLastName());
		company.setPrivacyPolicy(companyBean.getPrivacyPolicy());
		company.setScheduleCall(companyBean.getScheduler());
		CompanySize addCompanySize=new CompanySize();
		addCompanySize.setCompanySizeId(companyBean.getSizeId());
		company.setCompanySize(addCompanySize);
		Industry addIndustry=new Industry();
		addIndustry.setIndustryId(companyBean.getIndustryId());
		company.setIndustry(addIndustry);
		
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

	@Override
	public boolean findByCompanyEmail(String compnayEmail) {
		Company companyDetail=companyRepository.findByEmail(compnayEmail);
		if(companyDetail!=null) {
			return true;
		}
		return false;
	}

	@Override
	public CompanyBean getCompanyDetailsByEmail(String email) {
		CompanyBean companyBean=null;
		List<QuestionResponseBean> questionBeans = new ArrayList<QuestionResponseBean>();
		Company companyDetail=companyRepository.findByEmail(email);
		if(companyDetail!=null) {
			companyBean=new CompanyBean();
			companyBean.setCompanyName(companyDetail.getCompanyName());
			companyBean.setEmail(companyDetail.getEmail());
			companyBean.setFirstName(companyDetail.getFirstName());
			companyBean.setLastName(companyDetail.getLastName());
			if(companyDetail.getIndustry()!=null)
			companyBean.setIndustryId(companyDetail.getIndustry().getIndustryId());
			companyBean.setPhone(companyDetail.getPhone());
			companyBean.setPrivacyPolicy(companyDetail.getPrivacyPolicy());
			companyBean.setScheduler(companyDetail.getScheduleCall());
			if(companyDetail.getCompanySize()!=null)
			companyBean.setSizeId(companyDetail.getCompanySize().getCompanySizeId());
			List<Questions> listQuestions=questionsRepository.findAll();
			if(listQuestions!=null && !listQuestions.isEmpty()) {
				listQuestions.stream().forEach(question->{
					QuestionResponseBean questionBean = new QuestionResponseBean();
					questionBean.setQuestionId(question.getQuestionsId());
					if(question.getCategories()!=null)
					questionBean.setSelectedOption(question.getCategories().getCategoriesId());
					questionBean.setResponseFlag(question.getActiveFlag());
					questionBeans.add(questionBean);
				});
			}
			companyBean.setQuestionBeans(questionBeans);
		}
		return companyBean;
	}

	@Override
	public List<CompanyBean> getCompanyDetails() {
		List<CompanyBean> companyBeans=new ArrayList<CompanyBean>();
		List<QuestionResponseBean> questionBeans = new ArrayList<QuestionResponseBean>();
		List<Company> listOfAllCompany=companyRepository.findAll();
		if(listOfAllCompany!=null && !listOfAllCompany.isEmpty()) {
			List<Questions> listQuestions=questionsRepository.findAll();
			if(listQuestions!=null && !listQuestions.isEmpty()) {
				listQuestions.stream().forEach(question->{
					QuestionResponseBean questionBean = new QuestionResponseBean();
					questionBean.setQuestionId(question.getQuestionsId());
					if(question.getCategories()!=null)
					questionBean.setSelectedOption(question.getCategories().getCategoriesId());
					questionBean.setResponseFlag(question.getActiveFlag());
					questionBeans.add(questionBean);
				});
			}
			listOfAllCompany.stream().forEach(companyDetail->{
				CompanyBean companyBean=new CompanyBean();
				companyBean.setCompanyName(companyDetail.getCompanyName());
				companyBean.setEmail(companyDetail.getEmail());
				companyBean.setFirstName(companyDetail.getFirstName());
				companyBean.setLastName(companyDetail.getLastName());
				if(companyDetail.getIndustry()!=null)
				companyBean.setIndustryId(companyDetail.getIndustry().getIndustryId());
				companyBean.setPhone(companyDetail.getPhone());
				companyBean.setPrivacyPolicy(companyDetail.getPrivacyPolicy());
				companyBean.setScheduler(companyDetail.getScheduleCall());
				if(companyDetail.getCompanySize()!=null)
				companyBean.setSizeId(companyDetail.getCompanySize().getCompanySizeId());
				if(questionBeans!=null && !questionBeans.isEmpty())
				companyBean.setQuestionBeans(questionBeans);
				companyBeans.add(companyBean);
			});
		}
		return companyBeans;
	}

}
