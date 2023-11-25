package net.training1.employeeservice.service;

import net.training1.employeeservice.dto.APIResponseDto;
import net.training1.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long employeeId);

}
