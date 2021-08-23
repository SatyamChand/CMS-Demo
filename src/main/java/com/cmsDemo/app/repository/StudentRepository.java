package com.cmsDemo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cmsDemo.app.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {
	
}
