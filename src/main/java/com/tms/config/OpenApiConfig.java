package com.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	@Bean
    OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Terminal Management System")
                        .description("TMS API Application")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("TMS")
                                .url("https://tms.com")
                                .email("asbnotebook@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License()
                        		.name("License")
                        		.url("#"))
                );
    }
}
