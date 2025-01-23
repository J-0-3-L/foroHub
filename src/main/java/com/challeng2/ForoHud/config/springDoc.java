package com.challeng2.ForoHud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class springDoc {
    
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API foroHud")
                .description("API para la gestion de un foro de consultas")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Developer Backend")
                    .email("forohud@exmaple.com")
                    .url("www.github.com"))
            
            );
    }
}
