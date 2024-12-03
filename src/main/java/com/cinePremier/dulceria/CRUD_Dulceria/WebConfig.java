package com.cinePremier.dulceria.CRUD_Dulceria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS en todos los endpoints
                .allowedOrigins("https://cinemapremier-venta-fxfrcegeb3b6gdb5.mexicocentral-01.azurewebsites.net/") // Especifica el origen de tu frontend (ajústalo a tu URL)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*") // Cabeceras permitidas
                .allowCredentials(true); // Si necesitas enviar cookies o credenciales
    }
}
