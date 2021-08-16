package com.cms.controller;

import java.util.List;

import com.cms.document.Student;
import com.cms.service.StudentService;

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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudent(){
        List<Student> list = studentService.getAllStudent();
        return list;
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PostMapping("")
    public String createStudent( @RequestBody Student student ){
        return studentService.createStudent(student);
    }

    @PutMapping("")
    public String updateStudent( @RequestBody Student student ){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent( @PathVariable("id") int id ){
        return studentService.deleteStudent(id);
    }

}
