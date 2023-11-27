package net.training1.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "DepartmentDTO class")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

	private Long id;

	@Schema(description = "Department Name")
	@NotEmpty(message = "Department name should not be empty")
	private String departmentName;

	@Schema(description = "Department Description")
	@NotEmpty(message = "Department description should not be empty")
	private String departmentDescription;

	@Schema(description = "Department Code")
	@NotEmpty(message = "Department Code should not be empty")
	private String departmentCode;

}
