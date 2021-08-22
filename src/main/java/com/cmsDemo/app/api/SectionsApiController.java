package com.cmsDemo.app.api;

import com.cmsDemo.app.model.Section;
import com.cmsDemo.app.model.Student;
import com.cmsDemo.app.model.Teacher;
import com.cmsDemo.app.service.SectionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-20T11:36:07.743+05:30")

@RestController
public class SectionsApiController implements SectionsApi {

    private static final Logger log = LoggerFactory.getLogger(SectionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private SectionService sectionService;

    @org.springframework.beans.factory.annotation.Autowired
    public SectionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Section>> getAllSections() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<Section> list = sectionService.getAllSections();
                return new ResponseEntity<List<Section>>(list, HttpStatus.OK);
            } catch (Exception e) {
                //log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Section>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Section>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Section> getSectionById(@ApiParam(value = "ID of Section to return",required=true) @PathVariable("sectionId") String sectionId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	Section section = sectionService.getSectionById(sectionId);
                return new ResponseEntity<Section>(section, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Section>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Section>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createSection(@ApiParam(value = "Section object" ,required=true )  @Valid @RequestBody Section body) {
        String accept = request.getHeader("Accept");
        if( sectionService.createSection(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Void> updateSection(@ApiParam(value = "section object" ,required=true )  @Valid @RequestBody Section body) {
        String accept = request.getHeader("Accept");
        if( sectionService.updateSection(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteSection(@ApiParam(value = "ID of Section",required=true) @PathVariable("sectionId") String sectionId) {
        String accept = request.getHeader("Accept");
        if( sectionService.deleteSection(sectionId) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK );
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
