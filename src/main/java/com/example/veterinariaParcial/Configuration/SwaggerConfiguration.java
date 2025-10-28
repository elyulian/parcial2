package com.example.veterinariaParcial.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
    return new OpenAPI()
            .info(new Info()
                    .title("API de Veterinaria")
                    .version("1.0")
                    .description("Documentacion de la API de veterinaria")
                    .contact(new Contact()
                            .name("Veterinaria API")
                            .email("juliandherrera@ucundinamarca.edu.co")));
    }
}

