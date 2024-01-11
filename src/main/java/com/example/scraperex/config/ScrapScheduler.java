package com.example.scraperex.config;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScrapScheduler {

    private final WebScraper webScraper;

    @Scheduled(cron = "0 08 16 ? * THU")
    public void runningScraperJson(){
        webScraper.process();
    }

}
