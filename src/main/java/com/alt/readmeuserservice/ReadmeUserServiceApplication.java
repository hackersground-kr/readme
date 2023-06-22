package com.alt.readmeuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
@PropertySource("classpath:jwt.properties")
public class ReadmeUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadmeUserServiceApplication.class, args);
	}

}
