package com.cms.service;

import java.util.List;
import java.util.Optional;

import com.cms.document.Teacher;
import com.cms.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById( int id ){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

    public String createTeacher( Teacher teacher ) {
        Optional<Teacher> existing = teacherRepository.findById(teacher.getId());
        if( existing.isEmpty() ){
            teacherRepository.save(teacher);
            return "{ status: \"success\", id: \""+ teacher.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ teacher.getId() +"\" }";
        }
    }

    public String updateTeacher( Teacher teacher ) {
        Optional<Teacher> existing = teacherRepository.findById(teacher.getId());
        if( existing.isPresent() ){
            teacherRepository.save(teacher);
            return "{ status: \"success\", id: \""+ teacher.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ teacher.getId() +"\" }";
        }
    }

    public String deleteTeacher( int id ){
        if( teacherRepository.findById(id).isPresent() ){
            teacherRepository.deleteById(id);
            return "{ status: \"success\", id: \""+ id +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ id +"\" }";
        }
    }

}
