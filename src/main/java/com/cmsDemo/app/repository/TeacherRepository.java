package com.cmsDemo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cmsDemo.app.model.Teacher;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, Long> {
    
}
