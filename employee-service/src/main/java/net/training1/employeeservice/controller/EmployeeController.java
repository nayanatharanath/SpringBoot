package net.training1.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.training1.employeeservice.dto.APIResponseDto;
import net.training1.employeeservice.dto.EmployeeDto;
import net.training1.employeeservice.service.EmployeeService;

@Tag(name = "Employee Service", description = "Employee Service CRUD APIs")
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

	private EmployeeService employeeServ;

	// build save employee REST API
	@Operation(summary = "Employee-Service POST API", description = "POST API to add/create/save Employee")
	@ApiResponse(responseCode = "201", description = "Shows 201 CREATED Response code")
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeServ.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// build get employee REST API
	@Operation(summary = "Employee-Service GET API", description = "GET API to get employee details by employee id")
	@ApiResponse(responseCode = "200", description = "Shows 200 OK Response code")
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
		APIResponseDto apiResponseDto = employeeServ.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}

}
