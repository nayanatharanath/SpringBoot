package com.example.student.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.student.model.Student;
import com.example.student.service.StudentServ;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
//public class StudentControllerTest {
//
//	 private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
//
//	    @InjectMocks
//	    private StudentController studentController;
//
//	    @Mock
//	    private StudentServ studentService;
//
//	    @Test
//	    void testGetAllStudents() {
//	        // Mocking data
//	        List<Student> mockStudents = new ArrayList<>();
//	        mockStudents.add(new Student(25, "John", 50000));
//	        mockStudents.add(new Student(22, "Alice", 45000));
//
//	        // Mocking service behavior
//	        Mockito.when(studentService.getAllStudents()).thenReturn(mockStudents);
//
//	        // Perform the test
//	        List<Student> result = studentController.getAllStudents();
//
//	        // Assertion
//	        assertEquals(mockStudents, result);
//	        Mockito.verify(LOGGER, Mockito.times(1)).info("Get All Student data");
//	    }
//
//	    @Test
//	    void testUpdate() {
//	        // Mocking data
//	        Student inputStudent = new Student(30, "Bob", 60000);
//
//	        // Mocking service behavior
//	        Mockito.when(studentService.update(Mockito.any(Student.class))).thenReturn(inputStudent);
//
//	        // Perform the test
//	        ResponseEntity<Student> result = studentController.update(inputStudent);
//
//	        // Assertion
//	        assertEquals(HttpStatus.OK, result.getStatusCode());
//	        assertEquals(inputStudent, result.getBody());
//	        Mockito.verify(LOGGER, Mockito.times(1)).info("Update Data");
//	    }
//
//	    @Test
//	    void testDelete() {
//	        // Mocking data
//	        String studentName = "Charlie";
//
//	        // Perform the test
//	        ResponseEntity<Void> result = studentController.delete(studentName);
//
//	        // Assertion
//	        assertEquals(HttpStatus.OK, result.getStatusCode());
//	        Mockito.verify(LOGGER, Mockito.times(1)).info("Delete Data");
//	    }
//
//	    @Test
//	    void testAdd() {
//	        // Mocking data
//	        Student inputStudent = new Student("David", 28, 55000);
//
//	        // Mocking service behavior
//	        Mockito.when(studentService.save(Mockito.any(Student.class))).thenReturn(inputStudent);
//
//	        // Perform the test
//	        ResponseEntity<Student> result = studentController.add(inputStudent);
//
//	        // Assertion
//	        assertEquals(HttpStatus.OK, result.getStatusCode());
//	        assertEquals(inputStudent, result.getBody());
//	        Mockito.verify(LOGGER, Mockito.times(1)).info("Add student data");
//	    }
//
//}
