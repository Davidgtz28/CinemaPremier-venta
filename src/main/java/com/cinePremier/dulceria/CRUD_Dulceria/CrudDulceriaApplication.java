package com.cinePremier.dulceria.CRUD_Dulceria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrudDulceriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDulceriaApplication.class, args);
	}
        
        
        @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Permitir todos los orígenes, métodos y encabezados
				registry.addMapping("/")
						.allowedOrigins("*") // Permitir todos los orígenes
						.allowedMethods("*") // Permitir todos los métodos (GET, POST, etc.)
						.allowedHeaders("*"); // Permitir todos los encabezados
			}
		};
	}

}
