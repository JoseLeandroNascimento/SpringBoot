package com.projeto.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String hello(){

		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
