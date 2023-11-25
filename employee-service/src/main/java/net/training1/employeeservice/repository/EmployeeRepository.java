package net.training1.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.training1.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
