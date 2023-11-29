package com.example.Studentexample.service;

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

import com.example.Studentexample.model.Student;
import com.example.Studentexample.repository.StudentRepo;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void testAddStudent() {
        // Arrange
        Student studentToAdd = new Student(1,"Pragathi", 20, 50000);
        when(studentRepo.save(studentToAdd)).thenReturn(studentToAdd);

        // Act
        Student addedStudent = studentService.addStudent(studentToAdd);

        // Assert
        assertEquals(studentToAdd, addedStudent);
        verify(studentRepo, times(1)).save(studentToAdd);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        List<Student> studentList = Arrays.asList(new Student(1,"Pragathi", 20, 50000),
                new Student(2,"ritika", 22, 60000));
        when(studentRepo.findAll()).thenReturn(studentList);

        // Act
        List<Student> retrievedStudents = studentService.getAllStudents();

        // Assert
        assertEquals(studentList, retrievedStudents);
        verify(studentRepo, times(1)).findAll();
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        int studentIdToDelete = 1;

        // Act
        studentService.deleteStudent(studentIdToDelete);

        // Assert
        verify(studentRepo, times(1)).deleteById(studentIdToDelete);
    }

    @Test
    void testDeleteAllStudents() {
        // Act
        studentService.deleteAllStudents();

        // Assert
        verify(studentRepo, times(1)).deleteAll();
    }

    @Test
    void testGetStudent() {
        // Arrange
        int studentId = 1;
        Student expectedStudent = new Student(1,"Pragathi", 20, 50000);
        when(studentRepo.findById(studentId)).thenReturn(Optional.of(expectedStudent));

        // Act
        Optional<Student> retrievedStudent = studentService.getStudent(studentId);

        // Assert
        assertTrue(retrievedStudent.isPresent());
        assertEquals(expectedStudent, retrievedStudent.get());
        verify(studentRepo, times(1)).findById(studentId);
    }

    @Test
    void testSave() {
        // Arrange
        Student studentToSave = new Student(1,"Pragathi", 20, 50000);
        when(studentRepo.save(studentToSave)).thenReturn(studentToSave);

        // Act
        Student savedStudent = studentService.save(studentToSave);

        // Assert
        assertEquals(studentToSave, savedStudent);
        verify(studentRepo, times(1)).save(studentToSave);
    }
}
