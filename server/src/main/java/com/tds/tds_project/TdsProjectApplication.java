package com.tds.tds_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan("com.tds.tds_project.entity")
@EnableJpaRepositories("com.tds.tds_project.repository")
public class TdsProjectApplication {

	public static void main(String[] args) {
        System.setProperty("server.port", "8080");
		SpringApplication.run(TdsProjectApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurer() {
		  @Override
		  public void addCorsMappings(CorsRegistry registry) {
			 registry.addMapping("/**").allowedOrigins("http://localhost:5173");
		  }    
	   };
	}
}

