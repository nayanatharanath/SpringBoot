package net.project1.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// HTTP GET REQUEST

	// Spring Boot REST API @GetMapping
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

}
