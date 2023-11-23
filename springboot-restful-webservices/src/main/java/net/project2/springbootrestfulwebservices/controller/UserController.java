package net.project2.springbootrestfulwebservices.controller;

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
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.project2.springbootrestfulwebservices.entity.User;
import net.project2.springbootrestfulwebservices.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userServ;

	// build create user REST API
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userServ.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get user by id REST API
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userServ.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// build get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServ.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// build update user REST API
	@PutMapping("{id}")
	public ResponseEntity<User> updatedUser(@PathVariable("id") Long userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = userServ.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Build delete user rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userServ.deleteUser(userId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
