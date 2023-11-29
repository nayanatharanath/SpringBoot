package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student.model.Student;

@Service
public interface StudentServ {

	Student addStudent(Student student);

	List<Student> getAllStudents();

	void deleteStudent(int id);

	Optional<Student> getStudent(int id);

	void deleteAllStudents();

	Student save(Student student);

}
