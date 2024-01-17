package com.example.scraperex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private String cardDetailUrl; // 카드 디테일 정보 페이지 URL
    private String benefitKeyword;



    @Builder
    public Card(String imageUrl, String cardName, String cardCorp, Map<String, String> storeNum, String lastMonth, String cardDetailUrl, String benefitKeyword, String notification) {
        this.imageUrl = imageUrl;
        this.cardName = cardName;
        this.cardCorp = cardCorp;
        this.storeNum = storeNum;
        this.lastMonth = lastMonth;
        this.cardDetailUrl = cardDetailUrl;
        this.notification = notification;
        this.benefitKeyword = benefitKeyword;
    }


}
