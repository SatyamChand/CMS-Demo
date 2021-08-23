package com.cmsDemo.app.api;

import com.cmsDemo.app.model.Section;
import com.cmsDemo.app.model.Student;
import com.cmsDemo.app.model.Teacher;
import com.cmsDemo.app.repository.TeacherRepository;
import com.cmsDemo.app.service.TeacherService;
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
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-20T11:36:07.743+05:30")

@RestController
public class TeachersApiController implements TeachersApi {

    private static final Logger log = LoggerFactory.getLogger(TeachersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TeacherService teacherService;

    @Autowired
    public TeachersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Teacher>> getAllTeachers() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<Teacher> list = teacherService.getAllTeachers();
                return new ResponseEntity<List<Teacher>>(list, HttpStatus.OK);
            } catch (Exception e) {
                //log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Teacher>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Teacher>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Teacher> getTeacherById(@ApiParam(value = "ID of Teacher to return",required=true) @PathVariable("teacherId") Long teacherId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	Optional<Teacher> teacher = teacherService.getTeacherById(teacherId);
            	if( teacher.isPresent() ) {
            		return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
            	}
            	else {
            		return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
            	}
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Teacher>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Teacher>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createTeacher(@ApiParam(value = "Teacher object" ,required=true )  @Valid @RequestBody Teacher body) {
        String accept = request.getHeader("Accept");
        if( teacherService.createTeacher(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Void> updateTeacher(@ApiParam(value = "Teacher object" ,required=true )  @Valid @RequestBody Teacher body) {
        String accept = request.getHeader("Accept");
        if( teacherService.updateTeacher(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteTeacher(@ApiParam(value = "teacher id to delete",required=true) @PathVariable("teacherId") Long teacherId) {
        String accept = request.getHeader("Accept");
        if( teacherService.deleteTeacher(teacherId) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK );
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
