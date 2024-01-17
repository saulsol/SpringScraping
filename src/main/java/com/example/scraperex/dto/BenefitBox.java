package com.example.scraperex.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BenefitBox {

    private String benefitTitle; // 카페
    private String benefitSubTitle; // 스타벅스(사이렌오더 포함) 50% 청구할인
    private List<String> detailList;

    /*
    * [커피]

    스타벅스(사이렌오더 포함) 50% 청구할인
        - 일 1회, 월 2회 제공
        - 상품권 및 선불카드 구매·충전 제외
            *일 한도 5천원
            *월 한도 1만원
    * */

    @Builder
    public BenefitBox(String benefitTitle, String benefitSubTitle, List<String> detailList) {
        this.benefitTitle = benefitTitle;
        this.benefitSubTitle = benefitSubTitle;
        this.detailList = detailList;
    }
}
