package com.example.springbatchudemy;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan({"com.example.config", "com.example.service"})
public class SpringBatchUdemyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchUdemyApplication.class, args);
    }

}
