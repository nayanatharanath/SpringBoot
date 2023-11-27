package net.training1.departmentservice.mapper;

import net.training1.departmentservice.dto.DepartmentDto;
import net.training1.departmentservice.entity.Department;

public class DepartmentMapper {

	public static DepartmentDto maptToDepartmentDto(Department department) {
		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());

		return departmentDto;
	}

	public static Department maoToDepartment(DepartmentDto departmentDto) {
		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		return department;
	}

}
