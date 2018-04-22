package com.hygogg.overflow.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hygogg.overflow.models.Question;
import com.hygogg.overflow.models.Tag;
import com.hygogg.overflow.models.User;
import com.hygogg.overflow.services.QuestionService;
import com.hygogg.overflow.services.TagService;

@RestController
public class Tags {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private TagService tagService;
	
	public Tags(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/test")
	public String test(@RequestBody HashMap<String, String> body, HttpSession session) {
		body.remove("_csrf");
		Iterator<Entry<String, String>> it = body.entrySet().iterator();
		Question question = new Question();
		ArrayList<Tag> tags = new ArrayList<Tag>();
		ArrayList<String> errors = new ArrayList<String>();
		
		while (it.hasNext()) {
			HashMap.Entry<String, String> pair = (HashMap.Entry<String, String>) it.next();
            if(pair.getKey().equals("question")) {
            	question = new Question(pair.getValue());
            } else {
            	if(pair.getValue().length() > 1) {
            		tags.add(tagService.create(new Tag(pair.getValue())));
            	}
            }
            it.remove();
        }
		
		if(question.getQuestion().length() < 12) {
			errors.add("The question must be 12 characters or longer");
		}
		if(tags.size() == 0) {
			errors.add("There are no valid tags, tags must be 2 characters or more and seperated by spaces");
		}
		
		if(errors.size() > 0) {	
			// TODO: find a way to send the array list of errors in the response
			return "{\"status\":200, \"valid\": false}";
		} else {
			User user = (User) session.getAttribute("user");
			question.setUser(user);
			Question question1 = questionService.create(question);
			question1.setTags(tags);
			questionService.update(question1);
			return "{\"status\":200, \"valid\": true}";
		}
	}	
}