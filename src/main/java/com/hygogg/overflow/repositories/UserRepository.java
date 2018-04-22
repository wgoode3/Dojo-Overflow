package com.hygogg.overflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hygogg.overflow.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findById(Long id);
    User findByEmail(String email);
}
