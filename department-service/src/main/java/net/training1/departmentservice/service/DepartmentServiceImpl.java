package net.training1.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.training1.departmentservice.dto.DepartmentDto;
import net.training1.departmentservice.entity.Department;
import net.training1.departmentservice.mapper.DepartmentMapper;
import net.training1.departmentservice.repository.DepartmentRepository;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	// when spring will find a spring bean that has a single parameter constructor.
	// Then spring will automatically inject the dependency
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// convert department dto object to department jpa entity
//		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
//				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		Department department = DepartmentMapper.maoToDepartment(departmentDto);
		Department savedDepartment = departmentRepo.save(department);

//		DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
//				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(),
//				savedDepartment.getDepartmentCode());

		DepartmentDto savedDepartmentDto = DepartmentMapper.maptToDepartmentDto(savedDepartment);

		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepo.findByDepartmentCode(departmentCode);

//		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
//				department.getDepartmentDescription(), department.getDepartmentCode()
//
//		);

		DepartmentDto departmentDto = DepartmentMapper.maptToDepartmentDto(department);

		return departmentDto;
	}

}
