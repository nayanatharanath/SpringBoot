package com.example.Studentexample.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.mapping.Document;

class StudentTest {

	@Test
	void testStudentConstructor() {
		Student s = new Student(1,"Pragathi" ,20, 12345);
		
		assertNotNull(s);
		assertEquals("Pragathi", s.getName());
		assertEquals(20, s.getAge());
		assertEquals(12345, s.getSalary());
	}
	
	@Test
	void testGettersAndSetters() {
		
		Student s = new Student();
		
		s.setId(1);
		s.setName("Pragathi");
		s.setAge(20);
		s.setSalary(12345);
		
		assertEquals(1, s.getId());
		assertEquals("Pragathi", s.getName());
		assertEquals(20, s.getAge());
		assertEquals(12345, s.getSalary());
	}
	
	@Test
	void testBuilder() {
		Student s = Student.builder()
				.id(1)
				.name("Pragathi")
				.age(20)
				.salary(12345)
				.build();
		
		assertNotNull(s);
		assertEquals(1, s.getId());
		assertEquals("Pragathi", s.getName());
		assertEquals(20, s.getAge());
		assertEquals(12345, s.getSalary());
		

	}
	
	@Test
	void testEqualityandHashCode() {
		Student s1 = new Student(1,"Pragathi" ,20, 12345);
		Student s2 = new Student(1,"Pragathi" ,20, 12345);
		
		assertEquals(s1, s2);
		assertEquals(s1.hashCode(), s2.hashCode());
		
	}
	
	@Test
	void testToString() {
		Student s = new Student(1,"Pragathi" ,20, 12345);
		String expectedToString = "Student(id=1, name=Pragathi, age=20, salary=12345)";
		
		assertEquals(expectedToString, s.toString());

	}
	
}