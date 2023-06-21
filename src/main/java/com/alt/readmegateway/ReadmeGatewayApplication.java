package com.alt.readmegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:jwt.properties")
@PropertySource("classpath:database.properties")
@SpringBootApplication
@EnableDiscoveryClient
public class ReadmeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadmeGatewayApplication.class, args);
	}

}
