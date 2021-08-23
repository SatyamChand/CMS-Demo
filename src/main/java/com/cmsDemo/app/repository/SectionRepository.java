package com.cmsDemo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cmsDemo.app.model.Section;

@Repository
public interface SectionRepository extends MongoRepository<Section,String> {}