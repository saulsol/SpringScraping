package com.example.scraperex.config;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScrapScheduler {

    private final WebScraper webScraper;
    private final SeleniumScraper seleniumScraper;

    @Scheduled(cron = "0 24 15 ? * MON")
    public void runningScraperJson(){
        webScraper.process();
    }

    @Scheduled(cron = "0 51 16 ? * TUE")
    public void runningScraperSelenium(){
        seleniumScraper.scrapCardData();
    }

}
