package com.sprBoot.botp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
/*
 * @SpringBootApplication: This annotation is a combination
 * of @Configuration, @EnableAutoConfiguration, and @ComponentScan. It marks the
 * main class as a configuration class and enables auto-configuration and
 * component scanning.
 */