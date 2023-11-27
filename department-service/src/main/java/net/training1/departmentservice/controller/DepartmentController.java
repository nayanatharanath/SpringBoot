package net.training1.departmentservice.controller;

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
import net.training1.departmentservice.dto.DepartmentDto;
import net.training1.departmentservice.service.DepartmentService;

@Tag(name = "Department Service", description = "Department Service CRUD APIs")
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentServ;

	// build save department REST API
	@Operation(summary = "Department-Service POST API", description = "POST API to add/create/save department")
	@ApiResponse(responseCode = "201", description = "Shows 201 CREATED Response code")
	@PostMapping
	public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentServ.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	// build get department REST API
	@Operation(summary = "Department-Service GET API", description = "GET API to get department by department-code")
	@ApiResponse(responseCode = "200", description = "Shows 200 OK Response code")
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
		DepartmentDto departmentDto = departmentServ.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

}
