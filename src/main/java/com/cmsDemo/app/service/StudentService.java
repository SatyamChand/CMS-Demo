package com.cmsDemo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cmsDemo.app.model.Student;
import com.cmsDemo.app.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents(){
    	return studentRepository.findAll();
    }

    public Student getStudentById( Long id ){
        Optional<Student> student = studentRepository.findById(id);
        if( student.isEmpty() ) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist");
        }
        return student.get();
    }

    public Boolean createStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( !existing.isPresent() ){
            studentRepository.save(student);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( existing.isPresent() ){
            studentRepository.save(student);
            return true;
        }
        else{
        	return false;
        }
    }

    public Boolean deleteStudent( Long id ){
        if( studentRepository.findById(id).isPresent() ){
            studentRepository.deleteById(id);
            return true;
        }
        else{
        	return false;
        }
    }

}
