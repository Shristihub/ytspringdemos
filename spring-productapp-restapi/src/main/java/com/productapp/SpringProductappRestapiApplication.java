package com.productapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Product Catalog REST API",
		version = "1.0",
		description = "This is a REST API with rest end points for product"
		),
       servers = {
    		   @Server(url = "http://loalhost:8081", description = "Local Server")
       } )
public class SpringProductappRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappRestapiApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
