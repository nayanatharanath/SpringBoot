package com.example.Studentexample.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Studentexample.model.*;
import com.example.Studentexample.repository.StudentRepo;
import com.example.Studentexample.service.StudentService;

import lombok.AllArgsConstructor;

@RestController

@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	
	@PostMapping("addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student ) {
		logger.info("Method addStudent started");
		
		Student s= studentServ.addStudent(student);
		
		logger.info("Student added successfully");
		return new ResponseEntity<Student>(s,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student> > getStudents() {
		logger.info("Method getStudents started");
		List<Student> studentList = studentServ.getAllStudents();
		
		logger.info("Method getStudents completed");
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		logger.info("Method deleteStudent started");
		studentServ.deleteStudent(id);
		logger.info("Student got deleted successfully");
		return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
		logger.info("Method deleteAllStudents started");
		studentServ.deleteAllStudents();
		logger.info("All students deleted successfully");
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s, @PathVariable int id) {
		logger.info("Method updateStudent started");
		Optional<Student> st = studentServ.getStudent(id);
		Student student=st.get();
		student.setName(s.getName());
		student.setAge(s.getAge());
		student.setSalary(s.getSalary());
		logger.info("Student updated successfully");
		return new ResponseEntity<Student>(studentServ.save(student), HttpStatus.OK);
	}
	
	

}
