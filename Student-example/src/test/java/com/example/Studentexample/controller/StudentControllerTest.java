package com.example.Studentexample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Studentexample.model.Student;
import com.example.Studentexample.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testAddStudent() {
        // Arrange
        Student studentToAdd = new Student(1,"Pragathi", 20, 50000);
        when(studentService.addStudent(studentToAdd)).thenReturn(studentToAdd);

        // Act
        ResponseEntity<Student> response = studentController.addStudent(studentToAdd);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(studentToAdd, response.getBody());
    }

    @Test
    void testGetStudents() {
        // Arrange
        List<Student> studentList = Arrays.asList(new Student(1,"Pragathi", 20, 50000),
                new Student(1,"Ritika", 22, 60000));
        when(studentService.getAllStudents()).thenReturn(studentList);

        // Act
        ResponseEntity<List<Student>> response = studentController.getStudents();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studentList, response.getBody());
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        int studentIdToDelete = 1;

        // Act
        ResponseEntity<String> response = studentController.deleteStudent(studentIdToDelete);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student deleted successfully", response.getBody());
        verify(studentService, times(1)).deleteStudent(studentIdToDelete);
    }

    @Test
    void testDeleteAllStudents() {
        // Act
        ResponseEntity<String> response = studentController.deleteAllStudents();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Deleted successfully", response.getBody());
        verify(studentService, times(1)).deleteAllStudents();
    }

    @Test
    void testUpdateStudent() {
        // Arrange
        int studentIdToUpdate = 1;
        Student existingStudent = new Student(1,"Pragathi", 20, 50000);
        Student updatedStudent = new Student(1,"Pragathi", 25, 60000);
        when(studentService.getStudent(studentIdToUpdate)).thenReturn(Optional.of(existingStudent));
        when(studentService.save(existingStudent)).thenReturn(updatedStudent);

        // Act
        ResponseEntity<Student> response = studentController.updateStudent(updatedStudent, studentIdToUpdate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedStudent, response.getBody());
    }
}

