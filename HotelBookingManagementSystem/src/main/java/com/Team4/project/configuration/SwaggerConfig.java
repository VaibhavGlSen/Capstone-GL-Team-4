package com.Team4.project.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfo(
    			"HBMS",
    			"Custom API for auth based HOTEL BOOKING MANAGEMENT SYSTEM",
    			"1.0",
    			"",
    			new Contact("TEAM 4","www.hbms.com","teas@hbms.com"),
    			"",
    			"",
    			Collections.emptyList());
    }
}
