package com.example.Studentexample.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	 
	@Id
    private int id;
	private String name;
	private int age;
	private int salary; 

}
