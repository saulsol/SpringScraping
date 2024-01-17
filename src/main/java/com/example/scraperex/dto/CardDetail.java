package com.example.scraperex.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
public class CardDetail {

    private String event;
    private String eventDetail;
    private List<String> detailImageUrlList;
    private List<BenefitBox> benefitBoxes;

    @Builder
    public CardDetail(String event, String eventDetail, List<String> detailImageUrlList, List<BenefitBox> benefitBoxes) {
        this.event = event;
        this.eventDetail = eventDetail;
        this.detailImageUrlList = detailImageUrlList;
        this.benefitBoxes = benefitBoxes;
    }
}
