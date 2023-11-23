package net.project1.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.project1.springbootrestapi.bean.Student;

@RestController
@RequestMapping("example")
public class StudentController {

	// Spring boot REST API returns Java Bean
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "Aman", "Sharma");
		return student;
	}

	// Spring Boot REST API returns List
	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Aarya", "V"));
		students.add(new Student(2, "Bhargavi", "R"));
		students.add(new Student(3, "Chaitra", "R"));
		students.add(new Student(4, "Dhanveer", "K"));
		return students;
	}

	// Spring Boot REST API with a single PATH VARIABLE
	// {id} - URI Template variable
	// when the URI Template variable is different from the parameter passed
	// the below way is used
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId) {
		return new Student(studentId, "Aarya", "V");
	}

	// Spring Boot REST API with a multiple PATH VARIABLE
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable1(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}

	// Spring Boot REST API with a single Request Parameter
	// http://localhost:8080/students/query?id=1
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id) {
		return new Student(id, "Aarya", "V");
	}

	// Spring Boot REST API with a multiple Request Parameter
	// http://localhost:8080/students/queries?id=1&firstName=Aarya&lastName=V
	@GetMapping("students/queries")
	public Student studentRequestVariable1(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}

	// Spring boot REST API that handles HTTP POST request
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}

	// Spring boot REST API that handles HTTP PUT request
	@PutMapping("student/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}

	// Spring boot REST API that handles DELETE Request
	@DeleteMapping("student/{id}/delete")
	public String deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return "Deleted Successfully";
	}

	// Spring Boot REST API using ResponseEntity
	@GetMapping("studentRE")
	public ResponseEntity<Student> getStudent1() {
		Student student = new Student(1, "Aman", "Sharma");
		// return new ResponseEntity<>(student, HttpStatus.OK);
		// to pass header in a HTTP response using ResponseEntity class
		return ResponseEntity.ok().header("custom-header", "aarya").body(student);
	}

	@GetMapping("studentsRE")
	public ResponseEntity<List<Student>> getStudents1() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Aarya", "V"));
		students.add(new Student(2, "Bhargavi", "R"));
		students.add(new Student(3, "Chaitra", "R"));
		students.add(new Student(4, "Dhanveer", "K"));
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

}
