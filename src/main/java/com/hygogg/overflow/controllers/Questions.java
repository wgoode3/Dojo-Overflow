package com.hygogg.overflow.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hygogg.overflow.services.QuestionService;

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
	public String new_question(HttpSession session, RedirectAttributes flash) {
		if(session.getAttribute("user") == null) {
			flash.addFlashAttribute("error", "You need to sign in to your account first");
			return "redirect:/";
		}
		return "newquestion";
	}
	
}
