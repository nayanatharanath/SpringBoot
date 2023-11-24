package net.project2.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "UserDTO class")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	// user first name should not be null or empty
	@Schema(description = "first name")
	@NotEmpty(message = "User first name should not be empty")
	private String firstName;

	// user last name should not be null or empty
	@Schema(description = "last name")
	@NotEmpty(message = "User last name should not be empty")
	private String lastName;

	// user email should not be null or empty
	// email address shd be valid
	@Schema(description = "email")
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email should be valid")
	private String email;

}
