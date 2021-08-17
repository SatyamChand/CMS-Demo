package com.cms.controller;

import java.util.List;

import com.cms.document.Student;
import com.cms.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping( value = "", method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE } )
    public List<Student> getAllStudent(){
        List<Student> list = studentService.getAllStudent();
        return list;
    }
    
    @RequestMapping( value = "/{id}", method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public Student getStudentById(@PathVariable("id") int id) throws Exception {
        return studentService.getStudentById(id);
    }

    @RequestMapping( value = "", method = RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public void createStudent( @RequestBody Student student ){
        studentService.createStudent(student);
    }

    @RequestMapping( value = "", method = RequestMethod.PUT,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public void updateStudent( @RequestBody Student student ){
        studentService.updateStudent(student);
    }

    @RequestMapping( value = "", method = RequestMethod.DELETE,
    		produces = { MediaType.APPLICATION_JSON_VALUE } )
    public void deleteStudent( @PathVariable("id") int id ){
        studentService.deleteStudent(id);
    }

}
