package com.cms.service;

import java.util.List;
import java.util.Optional;

import com.cms.document.Student;
import com.cms.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent(){
    	List<Student> list = studentRepository.findAll();
    	if( list.size() == 0 ) {
    		throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No entries available" );
    	}
        return list;
    }

    public Student getStudentById( int id ){
        Optional<Student> student = studentRepository.findById(id);
        if( student.isEmpty() ) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist");
        }
        return student.get();
    }

    @ResponseStatus( HttpStatus.CREATED )
    public void createStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( !existing.isPresent() ){
            studentRepository.save(student);
        }
        else{
            throw new ResponseStatusException( HttpStatus.CONFLICT, "Student entry with id : "+ student.getId() +" exists" );
        }
    }

    @ResponseStatus( HttpStatus.OK )
    public void updateStudent( Student student ) {
        Optional<Student> existing = studentRepository.findById(student.getId());
        if( existing.isPresent() ){
            studentRepository.save(student);
        }
        else{
        	throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "Student does not exist");
        }
    }

    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteStudent( int id ){
        if( studentRepository.findById(id).isPresent() ){
            studentRepository.deleteById(id);
        }
        else{
        	throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Student not found" );
        }
    }

}
