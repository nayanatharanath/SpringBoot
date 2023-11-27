package net.training1.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "OrganizationDTO class")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;
	@Schema(description = "Organization Name")
	@NotEmpty(message = "Organization name should not be empty")
	private String organizationName;

	@Schema(description = "Organization Description")
	@NotEmpty(message = "Organization description should not be empty")
	private String organizationDescription;

	@Schema(description = "Organization Code")
	@NotEmpty(message = "Organization code should not be empty")
	private String organizationCode;

	private LocalDateTime createdDate;

}
