package com.cms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.cms.document.Section;
import com.cms.document.Student;
import com.cms.document.Teacher;
import com.cms.model.SubjectTeacher;
import com.cms.repository.SectionRepository;
import com.cms.repository.StudentRepository;
import com.cms.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private SectionRepository sectionRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		studentRepository.save(new Student(18001,"Satyam","K18AP"));
		studentRepository.save(new Student(18002,"Mohak","K18SR"));
		studentRepository.save(new Student(18003,"Mrityunjay","E18AA"));

		teacherRepository.save(new Teacher(101, "Rohit", "K18AP", new ArrayList<String>(Arrays.asList("K18AP","K18SR")), "Java"));
		teacherRepository.save(new Teacher(102, "Yash", "K18SR", new ArrayList<String>(Arrays.asList("K18AP","K18SR","E18AA")), "C"));

		List<SubjectTeacher> list = new ArrayList<SubjectTeacher>();
		list.add( new SubjectTeacher("Java",101) );
		list.add( new SubjectTeacher("C", 102) );
		sectionRepository.save( new Section("K18AP", 101, "CSE", list ) );
		
		list = new ArrayList<SubjectTeacher>();
		list.add( new SubjectTeacher("C", 102) );
		sectionRepository.save( new Section("K18SR", 102, "ECE", list ) );
	}

}
