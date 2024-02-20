package com.register.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class UsersRegisterSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersRegisterSpringSecurityApplication.class, args);
	}

}
