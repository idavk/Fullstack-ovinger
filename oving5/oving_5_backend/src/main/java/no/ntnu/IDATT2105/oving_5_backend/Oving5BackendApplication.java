package no.ntnu.IDATT2105.oving_5_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Oving5BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oving5BackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/calculate")
						.allowedMethods("GET", "POST")
						.allowedOrigins("http://localhost:8080");
			}
		};
	}

}
