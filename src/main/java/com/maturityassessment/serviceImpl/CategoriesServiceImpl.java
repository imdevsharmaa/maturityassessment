package com.maturityassessment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maturityassessment.beans.CategoriesBean;
import com.maturityassessment.beans.ResponseBean;
import com.maturityassessment.model.Categories;
import com.maturityassessment.repository.CategoriesRepository;
import com.maturityassessment.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Override
	public ResponseBean saveCategories(CategoriesBean categoriesBean) {
		ResponseBean responseBean = new ResponseBean();
		Categories categories = new Categories();
		categories.setCategory(categoriesBean.getCategory());
		categories.setDescription(categoriesBean.getDescription());
		categories.setActiveFlag(Boolean.TRUE);
		String body = "Categorie added " + categoriesRepository.save(categories).getCategoriesId();
		HttpStatus status = HttpStatus.OK;
		responseBean.setBody(body);
		responseBean.setStatus(status);
		return responseBean;
	}

}
