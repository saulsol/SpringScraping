package com.example.scraperex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;


@Data
public class Card {

    private String imageUrl; //이미지 url
    private String cardName; //카드이름
    private String cardCorp; // 카드회사
    private Map<String, String> storeNum; // 혜택
    private String lastMonth; // 전월실적
    private String notification; // 특이사항


    public Card(String imageUrl, String cardName, String cardCorp, Map<String, String> storeNum, String lastMonth, String notification) {
        this.imageUrl = imageUrl;
        this.cardName = cardName;
        this.cardCorp = cardCorp;
        this.storeNum = storeNum;
        this.lastMonth = lastMonth;
        this.notification = notification;
    }


}
