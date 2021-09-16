package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class Demo6Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo6Application.class, args);
    }

    @Bean
    public Function<String, Boolean> containsCloud() {
        return value -> value.contains("cloud");
    }
}
