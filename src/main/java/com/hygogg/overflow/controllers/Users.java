package com.hygogg.overflow.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hygogg.overflow.models.User;
import com.hygogg.overflow.services.UserService;
import com.hygogg.overflow.validators.UserValidator;

@Controller
public class Users {

	private UserService userService;
	private UserValidator userValidator;

	public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/user")
	public String register(@RequestParam Map<String, String> body, RedirectAttributes flash, HttpSession session) {
		HashMap<String, String> validations = userValidator.register(body);
		if(validations.get("valid").equals("false")) {
			flash.addFlashAttribute("errors", validations);
			return "redirect:/signup";
		} else {
			session.setAttribute("user", userService.create(body));
			return "redirect:/";
		}
	}
	
	@PostMapping("/session")
	public String login(@RequestParam Map<String, String> body, RedirectAttributes flash, HttpSession session) {
		User user = userValidator.login(body);
		if(user == null) {
			flash.addFlashAttribute("errors", "Invalid credentials, please try again.");
			return "redirect:/signin";
		} else {
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
}
