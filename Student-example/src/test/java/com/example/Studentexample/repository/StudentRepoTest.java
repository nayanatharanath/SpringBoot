//package com.example.Studentexample.repository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.example.Studentexample.model.Student;
//
//@DataJpaTest
//public class StudentRepoTest {
//
//	@Autowired
//	private StudentRepo studentRepo;
//
//	// JUnit test for save student operation
//	@DisplayName("JUnit test for save student operation")
//	@Test
//	public void givenStudentObject_whenSave_thenReturnSavedStudent() {
//
//		// given - precondition or setup
//		Student student = Student.builder().name("Ramesh").age(45).salary(1000000).build();
//
//		// when - action or the behavior that we are going to test
//		Student savedStudent = studentRepo.save(student);
//
//		// then - verify the output
//		Assertions.assertThat(savedStudent).isNotNull();
//		Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);
//	}
//}
