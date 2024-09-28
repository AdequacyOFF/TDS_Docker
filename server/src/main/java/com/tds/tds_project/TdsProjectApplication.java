package com.tds.tds_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.tds.tds_project.entity")
@EnableJpaRepositories("com.tds.tds_project.repository")
public class TdsProjectApplication {

	public static void main(String[] args) {
        System.setProperty("server.port", "8080");
		SpringApplication.run(TdsProjectApplication.class, args);
	}
}
