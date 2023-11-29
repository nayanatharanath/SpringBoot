package com.example.Studentexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Studentexample.model.Student;


public interface StudentService {
	
	

	  Student addStudent(Student student);
	 
	  List<Student> getAllStudents();
	  
	  void deleteStudent(int id);
	  
	  Optional<Student> getStudent(int id);

	  void deleteAllStudents();

	  Student save(Student student);

	

}
