package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Server URL (IMPORTANT for your hosted environment)
        Server server = new Server();
        server.setUrl("https://9265.pro604cr.amypo.ai");
        server.setDescription("Hosted server");

        // API information
        Info info = new Info()
                .title("Insurance Fraud Detection API")
                .description("Spring Boot backend for Insurance Fraud Detection System")
                .version("1.0.0");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
