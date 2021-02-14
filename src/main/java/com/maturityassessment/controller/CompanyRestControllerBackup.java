package com.maturityassessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maturityassessment.beans.CompanyBean;
import com.maturityassessment.model.Company;
import com.maturityassessment.service.CompanyService;

/**
 * 
 * @author nitin.jaiswal
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/company")
public class CompanyRestControllerBackup {

	/*
	 * @Autowired private CompanyService companyService;
	 * 
	 * @GetMapping("/get") public ResponseEntity<?> getCompanyDetails() { return new
	 * ResponseEntity<>("Working", HttpStatus.OK); }
	 * 
	 * @PostMapping("/add") public ResponseEntity<?> saveCompanyData(@RequestBody
	 * Company company) { return new ResponseEntity<>("Company Details added " +
	 * companyService.saveCompanyDetails(company), HttpStatus.OK); }
	 * 
	 * // localhost:8080/company/get/all
	 * 
	 * @GetMapping("/get/all") public ResponseEntity<?> getAllCompanyDetails() {
	 * 
	 * ResponseEntity<?> response = null; try { List<Company> companies =
	 * companyService.getAllCompanyDetails(); if (companies == null ||
	 * companies.isEmpty()) { response = new ResponseEntity<>("No Companys Found",
	 * HttpStatus.OK); } else { response = new ResponseEntity<>(companies,
	 * HttpStatus.OK); } } catch (Exception e) { response = new
	 * ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); } return response;
	 * }
	 * 
	 * @GetMapping("/get/id/{companyId}") public ResponseEntity<?>
	 * getCompanyById(@PathVariable Integer companyId) {
	 * 
	 * ResponseEntity<?> response = null; try { System.out.println(companyId);
	 * Optional<Company> company = companyService.getcompanyById(companyId); if
	 * (company.isPresent()) { response = new ResponseEntity<>(company.get(),
	 * HttpStatus.OK); } else { response = new
	 * ResponseEntity<>("No Company Found with id " + companyId, HttpStatus.OK); } }
	 * catch (Exception e) { response = new ResponseEntity<>(e.getMessage(),
	 * HttpStatus.BAD_REQUEST); } return response; }
	 * 
	 * @PutMapping("/update") public ResponseEntity<String>
	 * updateCompany(@RequestBody CompanyBean companyBean) { ResponseEntity<String>
	 * response = null; try { if (companyBean != null && companyBean.getCompany_id()
	 * != null && companyService.isCompanyExist(companyBean.getCompany_id())) {
	 * Integer empId = companyService.addCompany(prepareCompanyDTO(companyBean));
	 * response = new ResponseEntity<>(empId + " Company Updated Successfully",
	 * HttpStatus.OK); } else { response = new ResponseEntity<>("No Company Found",
	 * HttpStatus.OK); } } catch (Exception e) { response = new
	 * ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); } return response;
	 * }
	 * 
	 * @GetMapping("/get/name/{companyName}") public ResponseEntity<?>
	 * getCompanysByEmpName(@PathVariable String companyName) {
	 * 
	 * ResponseEntity<?> response = null; try { System.out.println(companyName);
	 * List<Company> companies = companyService.findByCompanyName(companyName); if
	 * (companies == null || companies.isEmpty()) { response = new
	 * ResponseEntity<>("No Companys Found", HttpStatus.OK); } else { response = new
	 * ResponseEntity<>(companies, HttpStatus.OK); } } catch (Exception e) {
	 * response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); }
	 * return response; }
	 * 
	 * @DeleteMapping("/delete/all") public ResponseEntity<?> deleteAllCompanys() {
	 * 
	 * ResponseEntity<String> response = null; try { String status =
	 * companyService.deleteAllCompanies(); response = new ResponseEntity<>(status,
	 * HttpStatus.OK); } catch (Exception e) { response = new
	 * ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); } return response;
	 * }
	 * 
	 * @DeleteMapping("/delete/{companyId}") public ResponseEntity<String>
	 * deleteCompany(@PathVariable Integer companyId) { ResponseEntity<String>
	 * response = null; try { String status =
	 * companyService.deleteCompanyById(companyId); response = new
	 * ResponseEntity<>(status, HttpStatus.OK); } catch (Exception e) { response =
	 * new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); } return
	 * response; }
	 * 
	 * private Company prepareCompanyDTO(CompanyBean companyBean) { Company company
	 * = new Company(); if (companyBean.getCompany_id() != null) {
	 * company.setCompany_id(companyBean.getCompany_id()); }
	 * company.setCandidateEmail(companyBean.getCandidateEmail());
	 * company.setCandidateFirstName(companyBean.getCandidateFirstName());
	 * company.setCandidateId(companyBean.getCandidateId());
	 * company.setCandidateLastName(companyBean.getCandidateLastName());
	 * company.setCandidatePhone(companyBean.getCandidatePhone());
	 * company.setCompanyName(companyBean.getCompanyName());
	 * company.setIndustryId(companyBean.getIndustryId());
	 * company.setPrivecyPolicy(companyBean.getPrivacyPolicy());
	 * company.setScheduler(company.getScheduler());
	 * company.setSizeId(companyBean.getSizeId());
	 * 
	 * return company; }
	 * 
	 * @GetMapping("/getcompanysizedetails") public List<Integer>
	 * getCompanySizeDetails() { return companyService.getCompanySizeDetails(); }
	 */
}
