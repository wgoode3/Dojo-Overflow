package com.hygogg.overflow.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hygogg.overflow.models.Tag;


public interface TagRepository extends CrudRepository<Tag, Long>{
	
	@Query(value="SELECT * FROM tags WHERE subject=?1",nativeQuery=true)
	public ArrayList<Tag> findBySubject(String subject);
	
}
