package com.example.student.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServTest {

	@Autowired
	private StudentServImpl service;

	@MockBean
	private StudentRepo repository;

	@Test
	private void getAllStudentsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Student(23,"happy",78643.0), 
				new Student(23,"xyz",45648.9)).collect(Collectors.toList()));
		assertEquals(2, service.getAllStudents().size());
	}

}