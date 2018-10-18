package com.tarea2.paises_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PaisesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisesAppApplication.class, args);
	}
}
