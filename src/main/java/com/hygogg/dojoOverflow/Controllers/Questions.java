package com.hygogg.dojoOverflow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hygogg.dojoOverflow.Services.QuestionService;

@Controller
public class Questions {
	
	@Autowired
	private QuestionService questionService;
	
	public Questions(QuestionService questionService) {
		this.questionService = questionService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionService.all());
		return "index";
	}
	
	@RequestMapping("/question/new")
	public String new_question() {
		return "newquestion";
	}
	
}
