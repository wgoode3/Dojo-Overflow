package com.hygogg.overflow.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hygogg.overflow.models.User;
import com.hygogg.overflow.services.UserService;

@Component
public class UserValidator implements Validator{
	
	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserValidator(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
    @Override
    public void validate(Object object, Errors errors) {
    }
	
	public static Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+");

	public HashMap<String, String> register(Map<String, String> body){
		HashMap<String, String> response = new HashMap<String, String>();
		boolean valid = true;
		
		if(body.get("firstName").length() < 3) {
			valid = false;
			response.put("firstName", "First Name must be 3 characters or longer");
		}
		
		if(body.get("lastName").length() < 3) {
			valid = false;
			response.put("lastName", "Last Name must be 3 characters or longer");
		}
		
		if(body.get("email").length() < 1) {
			valid = false;
			response.put("email", "Email is required");
		} else if(!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			valid = false;
			response.put("email", "Invalid Email");
		} else if(userService.findByEmail(body.get("email")) != null) {
			valid = false;
			response.put("email", "Email is already in use");
		}

		
		if(body.get("username").length() < 3) {
			valid = false;
			response.put("username", "Username must be 3 characters or longer");
		} else if(userService.findByUsername(body.get("username")) != null) {
			valid = false;
			response.put("username", "Username is already in use");
		}
		
		if(body.get("password").length() < 8) {
			valid = false;
			response.put("password", "Password must be 8 characters or longer");
		}
		
		if(!body.get("passwordConfirmation").equals(body.get("password"))){
			valid = false;
			response.put("passwordConfirmation", "Confirm Password must match Password");
		}
		
		if(valid) {
			response.put("valid", "true");
		} else {
			response.put("valid", "false");
		}
		
		return response;
		
	}
	
	public User login(Map<String, String> body){
		
		boolean valid = true;
		
		if(body.get("email").length() < 1) {
			valid = false;
		} else if(!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			valid = false;
		}
		
		if(body.get("password").length() < 8) {
			valid = false;
		}
		
		User user = null;
		
		if(valid) {			
			user = userService.findByEmail(body.get("email"));
			if(user == null) {
				valid = false;
			}
		}		
		
		if(valid && bCryptPasswordEncoder.matches(body.get("password"), user.getPassword())) {
			return user;
		} else {
			return null;
		}
		
	}
	
}
