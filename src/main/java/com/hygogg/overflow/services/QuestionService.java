package com.hygogg.overflow.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hygogg.overflow.models.Question;
import com.hygogg.overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question create(Question question) {
		return questionRepository.save(question);
	}
	
	public Question update(Question question) {
		return questionRepository.save(question);
	}
	
	public ArrayList<Question> all() {
		return (ArrayList<Question>) questionRepository.findAll();
	}
	
	public Question getQuestionById(Long questionId) {
		return questionRepository.getQuestionById(questionId);
	}

}
