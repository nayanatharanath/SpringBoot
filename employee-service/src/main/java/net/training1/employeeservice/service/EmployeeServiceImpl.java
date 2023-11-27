package net.training1.employeeservice.service;

// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import net.training1.employeeservice.dto.APIResponseDto;
import net.training1.employeeservice.dto.DepartmentDto;
import net.training1.employeeservice.dto.EmployeeDto;
import net.training1.employeeservice.dto.OrganizationDto;
import net.training1.employeeservice.entity.Employee;
import net.training1.employeeservice.mapper.EmployeeMapper;
import net.training1.employeeservice.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;

	// private RestTemplate restTemplate;

	private WebClient webClient;

	// private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

//		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
//				employeeDto.getEmail(), employeeDto.getDepartmentCode(), employeeDto.getOrganizationCode());

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee savedEmployee = employeeRepo.save(employee);

//		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
//				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode(),
//				savedEmployee.getOrganizationCode());

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).get();

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

//		DepartmentDto departmentDto = responseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

//		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

//		OrganizationDto organizationDto = apiClient.getOrganization(employee.getOrganizationCode());

		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();

//		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
//				employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setOrganization(organizationDto);

		return apiResponseDto;
	}

}
