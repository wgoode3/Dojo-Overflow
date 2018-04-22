package com.hygogg.overflow.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hygogg.overflow.models.Question;


public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	@Query(value="SELECT * FROM questions WHERE id=?1",nativeQuery=true)
	public Question getQuestionById(Long questionId);
	
}