package com.example.foodmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EvosWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvosWebsiteApplication.class, args);
    }

}
