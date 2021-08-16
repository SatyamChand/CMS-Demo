package com.cms.controller;

import java.util.List;

import com.cms.document.Teacher;
import com.cms.service.TeacherService;

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
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> getAllTeacher(){
        List<Teacher> list = teacherService.getAllTeacher();
        return list;
    }
    
    @GetMapping("/{id}")
    public Teacher getTeacherById( @PathVariable("id") int id ){
        return teacherService.getTeacherById(id);
    }

    @PostMapping("")
    public String createTeacher( @RequestBody Teacher teacher ){
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("")
    public String updateTeacher( @RequestBody Teacher teacher ){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher( @PathVariable("id") int id ){
        return teacherService.deleteTeacher(id);
    }

}
