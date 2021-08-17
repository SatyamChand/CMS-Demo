package com.cms.controller;

import java.util.List;

import com.cms.document.Section;
import com.cms.service.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sections")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;

    @RequestMapping( value = "", method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public List<Section> getAllSections(){
        return sectionService.getAllSections();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public Section getSectionByName( @PathVariable("id") String id ){
        return sectionService.getSectionById(id);
    }

    @RequestMapping( value = "", method = RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public String createSection( @RequestBody Section section ){
        return sectionService.createSection(section);
    }

    @RequestMapping( value = "", method = RequestMethod.PUT,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public String updateSection( @RequestBody Section section ){
        return sectionService.updateSection(section);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE,
    		produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public String deleteSection( @PathVariable("id") String id ){
        return sectionService.deleteSection(id);
    }

}
