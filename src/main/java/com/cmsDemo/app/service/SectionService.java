package com.cmsDemo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmsDemo.app.model.Section;
import com.cmsDemo.app.repository.SectionRepository;

@Service
public class SectionService{

    @Autowired
    private SectionRepository sectionRepository;


    public List<Section> getAllSections(){
        return sectionRepository.findAll();
    }

    public Optional<Section> getSectionById( String id ){
        return sectionRepository.findById(id);
    }

    public Boolean createSection( Section section ) {
        Optional<Section> existing = sectionRepository.findById(section.getId());
        if( existing.isEmpty() ){
            sectionRepository.save(section);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateSection( Section section ) {
        Optional<Section> existing = sectionRepository.findById(section.getId());
        if( existing.isPresent() ){
            sectionRepository.save(section);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean deleteSection( String id ){
        if( sectionRepository.findById(id).isPresent() ){
            sectionRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}