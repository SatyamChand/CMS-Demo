package com.cms.controller;

import java.util.List;

import com.cms.document.Section;
import com.cms.service.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sections")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;

    @GetMapping("")
    public List<Section> getAllSections(){
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public Section getSectionByName( @PathVariable("id") String id ){
        return sectionService.getSectionById(id);
    }

    @PostMapping("")
    public String createSection( @RequestBody Section section ){
        return sectionService.createSection(section);
    }

    @PutMapping("")
    public String updateSection( @RequestBody Section section ){
        return sectionService.updateSection(section);
    }

    @DeleteMapping("/{id}")
    public String deleteSection( @PathVariable("id") String id ){
        return sectionService.deleteSection(id);
    }

}
