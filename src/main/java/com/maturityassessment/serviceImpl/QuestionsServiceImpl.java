package com.maturityassessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maturityassessment.beans.OptionsBean;
import com.maturityassessment.beans.QuestionBean;
import com.maturityassessment.beans.ResponseBean;
import com.maturityassessment.model.Categories;
import com.maturityassessment.model.Options;
import com.maturityassessment.model.Questions;
import com.maturityassessment.repository.CategoriesRepository;
import com.maturityassessment.repository.OptionsRepository;
import com.maturityassessment.repository.QuestionsRepository;
import com.maturityassessment.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	Logger logger = LoggerFactory.getLogger(QuestionsServiceImpl.class);

	@Autowired
	private QuestionsRepository questionsRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Override
	public ResponseBean saveQuestions(QuestionBean questionBean) {
		ResponseBean responseBean = new ResponseBean();
		String body = "";
		HttpStatus status = HttpStatus.OK;

		Optional<Categories> opcategories = categoriesRepository.findById(questionBean.getCategoriesId());

		if (opcategories.isPresent()) {
			Questions questions = this.getQuestionsFromQuestionBean(questionBean, opcategories.get());
			final Questions dbquestions = questionsRepository.save(questions);
			this.prepareAndSaveOptions(questionBean.getOptionsBean(), dbquestions);
			body = "Questions Details added " + dbquestions.getQuestionsId();
		} else {
			body = "Please provide a valid Categories Id.";
			status = HttpStatus.BAD_REQUEST;
		}

		responseBean.setBody(body);
		responseBean.setStatus(status);
		return responseBean;
	}

	private void prepareAndSaveOptions(List<OptionsBean> optionsBean, Questions dbquestions) {
		Options options = null;
		for (OptionsBean option : optionsBean) {
			options = new Options();
			options.setActiveFlag(Boolean.TRUE);
			options.setQuestions(dbquestions);
			options.setOption(option.getOption());
			options.setWeightage(option.getWeightage());
			optionsRepository.save(options);
		}
	}

	@Override
	public QuestionBean getQuestionBeanById(Integer id) {
		QuestionBean questionBean = null;
		Optional<Questions> optional = questionsRepository.findById(id);
		if (optional.isPresent()) {
			Questions q = optional.get();
			List<Options> ops = optionsRepository.findByQuestions(q);
			questionBean = new QuestionBean();
			questionBean.setNoOfOptions(q.getNoOfOptions());
			questionBean.setQuestionId(q.getQuestionsId());
			questionBean.setQuestion(q.getQuestion());
			List<OptionsBean> list = new ArrayList<>();
			for (Options options : ops) {
				OptionsBean o = new OptionsBean();
				o.setOption(options.getOption());
				o.setWeightage(options.getWeightage());
				list.add(o);
			}
			questionBean.setOptionsBean(list);
			if (q.getCategories() != null) {
				questionBean.setCategoriesId(q.getCategories().getCategoriesId());
			}
		}
		return questionBean;
	}

	@SuppressWarnings("unused")
	@Override
	public List<QuestionBean> getAllQuestionBeans() {
		List<QuestionBean> questionBeans = new ArrayList<>();
		QuestionBean questionBean = null;
		List<Questions> questions = questionsRepository.findAll();
		logger.info("size " + questions.size());
		for (Questions q : questions) {
			List<Options> ops = optionsRepository.findByQuestions(q);
			questionBean = new QuestionBean();
			questionBean.setNoOfOptions(q.getNoOfOptions());
			questionBean.setQuestion(q.getQuestion());
			List<OptionsBean> list = new ArrayList<>();
			for (Options options : ops) {
				OptionsBean o = new OptionsBean();
				o.setOption(options.getOption());
				o.setWeightage(options.getWeightage());
				list.add(o);
			}
			questionBean.setOptionsBean(list);
			if (q.getCategories() != null) {
				questionBean.setCategoriesId(q.getCategories().getCategoriesId());
			}
			questionBeans.add(questionBean);
		}

		return questionBeans;
	}

	private Questions getQuestionsFromQuestionBean(QuestionBean questionBean, Categories categories) {
		Questions questions = new Questions();
		questions.setQuestion(questionBean.getQuestion());
		questions.setNoOfOptions(questionBean.getNoOfOptions());
		questions.setCategories(categories);
		questions.setActiveFlag(Boolean.TRUE);
		return questions;
	}
}
