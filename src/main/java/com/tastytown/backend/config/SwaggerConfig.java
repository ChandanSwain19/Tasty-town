package com.tastytown.backend.config;

import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(getInfo());
    }
    private Info getInfo() {
        var info =  new Info()
                .title("Tasty Town")
                .version("V2")
                .description("A Web Application for managing food delivery services");
                return info;
    }


    
}
