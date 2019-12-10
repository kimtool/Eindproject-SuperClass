package com.example.demodd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.example.demodd")
@EnableConfigurationProperties(StorageProperties.class)
public class DemoddApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoddApplication.class, args);
    }

}
