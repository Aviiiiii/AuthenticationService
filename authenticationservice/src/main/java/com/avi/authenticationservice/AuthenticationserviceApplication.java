package com.avi.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication/*(scanBasePackages = "com.avi.authenticationservice.*")*/
/*
@EnableJpaRepositories(basePackages = "com.avi.authenticationservice.dao.*")
*/
public class AuthenticationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationserviceApplication.class, args);
	}

}
