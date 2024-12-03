package com.cinePremier.dulceria.CRUD_Dulceria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

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
