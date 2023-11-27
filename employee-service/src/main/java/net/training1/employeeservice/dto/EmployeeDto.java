package net.training1.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDTO class")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;

	@Schema(description = "First Name")
	@NotEmpty(message = "First name should not be empty")
	private String firstName;

	@Schema(description = "Last Name")
	@NotEmpty(message = "Last name should not be empty")
	private String lastName;

	@Schema(description = "Email")
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email should be valid")
	private String email;

	@Schema(description = "Department Code")
	@NotEmpty(message = "Department code should not be empty")
	private String departmentCode;

	@Schema(description = "Organization Code")
	@NotEmpty(message = "Organization Code should not be empty")
	private String organizationCode;

}
