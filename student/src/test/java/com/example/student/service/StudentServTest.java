package com.example.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServTest {

	@InjectMocks
	private StudentServImpl service;

	@Mock
	private StudentRepo repository;

	@Test
	private void getAllStudentsTest() {
		List<Student> mockStudents = new ArrayList<>();
		mockStudents.add(new Student(24, "Jhon", 50000));
		mockStudents.add(new Student(25, "Alice", 45000));

		Mockito.when(repository.findAll()).thenReturn(mockStudents);

		List<Student> result = service.getAllStudents();

		assertEquals(mockStudents, result);
	}

	@Test
	void testUpdate() {
		// Mocking data
		Student inputStudent = new Student(30, "Bob", 60000);

		// Mocking repository behavior
		Mockito.when(repository.save(Mockito.any(Student.class))).thenReturn(inputStudent);

		// Perform the test
		service.update(inputStudent);

		// Assertion
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Student.class));
	}

	@Test
	void testDelete() {
		// Mocking data
		String studentName = "Charlie";

		// Perform the test
		service.delete(studentName);

		// Assertion
		Mockito.verify(repository, Mockito.times(1)).deleteByName(studentName);
	}

	@Test
	void testSave() {
		// Mocking data
		Student inputStudent = new Student(28, "David", 55000);

		// Mocking repository behavior
		Mockito.when(repository.save(Mockito.any(Student.class))).thenReturn(inputStudent);

		// Perform the test
		Student result = service.save(inputStudent);

		// Assertion
		assertEquals(inputStudent, result);
	}

}
