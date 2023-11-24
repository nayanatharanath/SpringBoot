package net.project2.springbootrestfulwebservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.project2.springbootrestfulwebservices.dto.UserDto;
import net.project2.springbootrestfulwebservices.entity.User;
import net.project2.springbootrestfulwebservices.exception.ErrorDetails;
import net.project2.springbootrestfulwebservices.exception.ResourceNotFoundException;
import net.project2.springbootrestfulwebservices.service.UserService;

@Tag(name = "CRUD REST APIs for User Resource", description = "CRUD REST APIs for User Resource description")
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userServ;

	// build create user REST API
	@Operation(summary = "POST API", description = "Post description")
	@ApiResponse(responseCode = "201", description = "201 - Created")
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = userServ.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get user by id REST API
	@Operation(summary = "GET by Id API", description = "get by id description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
		UserDto user = userServ.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// build get all users
	@Operation(summary = "GET API", description = "Get description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userServ.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// build update user REST API
	@Operation(summary = "Put API", description = "Put description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updatedUser(@PathVariable("id") Long userId, @Valid @RequestBody UserDto user) {
		user.setId(userId);
		UserDto updatedUser = userServ.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Build delete user rest API
	@Operation(summary = "DELETE API", description = "delete description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userServ.deleteUser(userId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//			WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
//				webRequest.getDescription(false), "USER_NOT_FOUND");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
