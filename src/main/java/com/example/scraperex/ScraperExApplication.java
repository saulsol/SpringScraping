package com.example.scraperex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScraperExApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraperExApplication.class, args);
    }

}
