package com.cms.service;

import java.util.List;
import java.util.Optional;

import com.cms.document.Section;
import com.cms.repository.SectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService{

    @Autowired
    private SectionRepository sectionRepository;


    public List<Section> getAllSections(){
        return sectionRepository.findAll();
    }

    public Section getSectionById( String id ){
        Optional<Section> section = sectionRepository.findById(id);
        return section.get();
    }

    public String createSection( Section section ) {
        Optional<Section> existing = sectionRepository.findById(section.getId());
        if( existing.isEmpty() ){
            sectionRepository.save(section);
            return "{ status: \"success\", id: \""+ section.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ section.getId() +"\" }";
        }
    }

    public String updateSection( Section section ) {
        Optional<Section> existing = sectionRepository.findById(section.getId());
        if( existing.isPresent() ){
            sectionRepository.save(section);
            return "{ status: \"success\", id: \""+ section.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ section.getId() +"\" }";
        }
    }

    public String deleteSection( String id ){
        if( sectionRepository.findById(id).isPresent() ){
            sectionRepository.deleteById(id);
            return "{ status: \"success\", id: \""+ id +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ id +"\" }";
        }
    }

}