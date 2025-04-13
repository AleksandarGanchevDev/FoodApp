package com.foodapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FoodappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodappBackendApplication.class, args);
	}

}
