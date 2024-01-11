package com.example.scraperex.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebScraper {

    private static final String url = "https://www.card-gorilla.com/card/detail/1616";
    public void process() {
        Connection conn = Jsoup.connect(url);
        //Jsoup 커넥션 생성

        Document document = null;
        try {
            document = conn.get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = getDataList(document);
        System.out.println("===============출력=============");
        System.out.println(list);
    }


    /**
     * data가져오기
     */
    private List<String> getDataList(Document document) {
        List<String> list = new ArrayList<>();
        String company = document.select("meta[name=keywords]").attr("content");
        String title = document.select("meta[property=og:title]").attr("content");
        String description = document.select("meta[name=description]").attr("content");
        String imageUrl = document.select("meta[property=og:image]").attr("content");
        System.out.println("_________________________________________________________________");

        if(title.contains("check") || title.contains("체크")){
            System.out.println("체크카드 입니다.");
        }

        System.out.println("뽑아온 회사 : " + company);
        System.out.println("카드 이름 : " + title);
        System.out.println("설명 : " + description);
        System.out.println("이미지 URL: " + imageUrl);

        return list;
    }

}
