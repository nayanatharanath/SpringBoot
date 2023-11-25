package net.training1.departmentservice.service;

import net.training1.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String departmentCode);
}
