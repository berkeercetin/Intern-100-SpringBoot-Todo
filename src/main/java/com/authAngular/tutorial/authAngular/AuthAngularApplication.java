package com.authAngular.tutorial.authAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "org.springframework.security.crypto.password")
public class AuthAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthAngularApplication.class, args);
	}

}
