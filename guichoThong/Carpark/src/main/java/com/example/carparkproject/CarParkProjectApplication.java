package com.example.carparkproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CarParkProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarParkProjectApplication.class, args);
    }

}
