package com.shop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Shop application.
 * <p>
 * This class initializes and runs the Spring Boot application.
 * It serves as the entry point for the application.
 * </p>
 *
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 */
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Shop API Definition",
				version = "1.0.0",
				description = "Shop API example",
				contact = @Contact(
						name = "Kaabi Mohamed",
						email = "kaabi.med@gmail.com"
				),
				license = @License(
						name = "openSource"
				)
		)
)
public class ShopApplication {

	/**
	 * The main method that starts the Shop application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
