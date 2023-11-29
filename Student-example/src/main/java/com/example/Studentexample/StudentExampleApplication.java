package com.example.Studentexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.Studentexample.repository.StudentRepo;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = StudentRepo.class)
public class StudentExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentExampleApplication.class, args);
	}

}
