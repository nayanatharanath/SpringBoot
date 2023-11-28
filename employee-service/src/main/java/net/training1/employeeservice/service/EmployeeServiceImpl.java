package net.training1.employeeservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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

	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	// @Retry(name = "${spring.application.name}", fallbackMethod =
	// "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

		LOGGER.info("Inside getEmployeeId()");

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

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		Employee employee = employeeRepo.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		// apiResponseDto.setOrganization(organizationDto);

		return apiResponseDto;

	}

}
