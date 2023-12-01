package upskill.casestudy.adminservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = " Admin Service REST APIs",
		description = "Admin Service REST APIs Documentation",
		version = "v1.0",
		contact = @Contact(
				name = "Kamini",
				email = "kamini@gmail.com",
				url = "https://www.google.com/"),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.google.com/"
		)
),
		externalDocs = @ExternalDocumentation(
				description = "Admin-service Doc"
		)
)
public class AdminServiceApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
