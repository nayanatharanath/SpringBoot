package net.training1.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.training1.departmentservice.dto.DepartmentDto;
import net.training1.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentServ;

	// build save department REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentServ.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	// build get department REST API
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
		DepartmentDto departmentDto = departmentServ.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

}
