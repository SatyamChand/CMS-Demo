package com.cms.service;

import java.util.List;
import java.util.Optional;

import com.cms.document.Student;
import com.cms.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById( int id ) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public String createStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( !existing.isPresent() ){
            studentRepository.save(student);
            return "{ status: \"success\", id: \""+ student.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ student.getId() +"\" }";
        }
    }

    public String updateStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( existing.isPresent() ){
            studentRepository.save(student);
            return "{ status: \"success\", id: \""+ student.getId() +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ student.getId() +"\" }";
        }
    }

    public String deleteStudent( int id ){
        if( studentRepository.findById(id).isPresent() ){
            studentRepository.deleteById(id);
            return "{ status: \"success\", id: \""+ id +"\" }";
        }
        else{
            return "{ status: \"failed\", id: \""+ id +"\" }";
        }
    }

}
