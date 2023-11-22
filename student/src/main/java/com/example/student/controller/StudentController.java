package com.example.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentServImpl;

@RestController
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServImpl serv;

	@GetMapping("/allStudents")
	private List<Student> getAllStudents() {
		log.info("Get All Student data");
		return serv.getAllStudents();
	}

	@PutMapping("/students/{name}")
	private Student update(@RequestBody Student student) {
		serv.update(student);
		log.info("Update Data");
		return student;
	}

	@DeleteMapping("/delete/{name}")
	private void delete(@PathVariable("name") String name) {
		log.info("Delete Data");
		serv.delete(name);
	}

	@PostMapping("/addStudent")
	private Student add(@RequestBody Student student) {
		log.info("Add student data");
		return serv.save(student);
	}

}
