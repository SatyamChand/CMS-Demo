package com.cmsDemo.app.service;

import java.util.List;
import java.util.Optional;

import com.cmsDemo.app.model.Teacher;
import com.cmsDemo.app.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById( Long id ){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

    public Boolean createTeacher( Teacher teacher ) {
        Optional<Teacher> existing = teacherRepository.findById(teacher.getId());
        if( existing.isEmpty() ){
            teacherRepository.save(teacher);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateTeacher( Teacher teacher ) {
        Optional<Teacher> existing = teacherRepository.findById(teacher.getId());
        if( existing.isPresent() ){
            teacherRepository.save(teacher);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean deleteTeacher( Long id ){
        if( teacherRepository.findById(id).isPresent() ){
            teacherRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}
