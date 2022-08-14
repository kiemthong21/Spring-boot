package com.fsoft.carpark;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@ComponentScan(basePackages = "com.fsoft.carpark.controller")
public class CarParkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }

}
