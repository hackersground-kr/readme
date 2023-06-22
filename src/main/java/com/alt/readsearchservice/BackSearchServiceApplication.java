package com.alt.readsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
@PropertySource("classpath:jwt.properties")
public class BackSearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackSearchServiceApplication.class, args);
    }

}
