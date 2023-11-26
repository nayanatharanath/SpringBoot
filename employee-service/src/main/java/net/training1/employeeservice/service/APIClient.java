package net.training1.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.training1.employeeservice.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8080/", value = "Department-Service")
// @FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	// build get department REST API
	@GetMapping("api/departments/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
