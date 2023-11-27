package net.training1.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

	private EmployeeDto employee;

	private DepartmentDto departmentDto;

	private OrganizationDto organization;

}
