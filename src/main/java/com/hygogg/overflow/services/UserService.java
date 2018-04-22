package com.hygogg.overflow.services;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hygogg.overflow.models.User;
import com.hygogg.overflow.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public User create(Map<String, String> body) {
    	User user = new User();
    	user.setFirstName(body.get("firstName"));
    	user.setLastName(body.get("lastName"));
    	user.setEmail(body.get("email"));
    	user.setUsername(body.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(body.get("password")));
        return userRepository.save(user);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User findById(long id) {
    	return userRepository.findById(id);
    }
    
    public User findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
}
