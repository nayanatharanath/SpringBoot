package com.example.Studentexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Studentexample.model.Student;
import com.example.Studentexample.repository.StudentRepo;

import lombok.AllArgsConstructor;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student addStudent(Student student) {
		Student addedStudent = studentRepo.save(student);
		return addedStudent;
//		return studentRepo.save(student);
	
	}
	public List<Student> getAllStudents() {
		List<Student> students = studentRepo.findAll();
		return students;
	}
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
		
	}
	
	public void deleteAllStudents() {
		studentRepo.deleteAll();
		
	}
	public Optional<Student> getStudent(int id) {
//		Student student = studentRepo.findById(id);
//		return student;
		return studentRepo.findById(id);
	}
	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
		
	}
	
	
	
	

}
