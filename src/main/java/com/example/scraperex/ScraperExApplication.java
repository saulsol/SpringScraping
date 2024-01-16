package com.example.scraperex;

import com.example.scraperex.config.SeleniumScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScraperExApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraperExApplication.class, args);
        SeleniumScraper seleniumScraper = new SeleniumScraper();
        seleniumScraper.scrapCardData();
    }

}
