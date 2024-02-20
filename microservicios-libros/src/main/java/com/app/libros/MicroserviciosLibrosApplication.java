package com.app.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosLibrosApplication.class, args);
	}

}
