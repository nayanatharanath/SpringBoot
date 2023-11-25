package net.training1.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.training1.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);

}
