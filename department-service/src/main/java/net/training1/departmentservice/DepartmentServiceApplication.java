package net.training1.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(info = @Info(title = "Department Rest API Documentation", description = "Department Rest API Documentation description", version = "v1.0", contact = @Contact(name = "Nayana", email = "", url = "https://www.youtube.com"), license = @License(name = "Apache 2.0", url = "")), externalDocs = @ExternalDocumentation(description = "External Doc", url = ""))
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
