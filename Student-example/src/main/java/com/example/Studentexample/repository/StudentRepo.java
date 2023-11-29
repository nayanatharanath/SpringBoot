package com.example.Studentexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Studentexample.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {

//	Student findByName(String name);
//
//	void deleteByname(String name);

	
	

}
