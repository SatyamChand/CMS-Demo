package com.cmsDemo.app.api;

import com.cmsDemo.app.model.Student;
import com.cmsDemo.app.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-20T11:36:07.743+05:30")

@RestController
public class StudentsApiController implements StudentsApi {

    private static final Logger log = LoggerFactory.getLogger(StudentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<Student> list = studentService.getAllStudents();
                return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
            } catch (Exception e) {
                //log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Student>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Student> getStudentById(@ApiParam(value = "ID of Student to return",required=true) @PathVariable("studentId") Long studentId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	Student student = studentService.getStudentById(studentId);
                return new ResponseEntity<Student>(student, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Student>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createStudent(@ApiParam(value = "Student object" ,required=true )  @Valid @RequestBody Student body) {
        String accept = request.getHeader("Accept");
        if( studentService.createStudent(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Void> updateStudent(@ApiParam(value = "Student object" ,required=true )  @Valid @RequestBody Student body) {
        String accept = request.getHeader("Accept");
        if( studentService.updateStudent(body) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteStudent(@ApiParam(value = "ID of Student",required=true) @PathVariable("studentId") Long studentId) {
        String accept = request.getHeader("Accept");
        if( studentService.deleteStudent(studentId) ) {
        	return new ResponseEntity<Void>(HttpStatus.OK );
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
