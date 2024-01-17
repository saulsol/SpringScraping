package com.example.scraperex.config;

import com.example.scraperex.dto.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;
@Component
public class SeleniumScraper {


    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
    }

    public List<Card> scrapCardData(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 꼭 있어야 하는 옵션
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");//팝업 무시
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        String baseUrl = "https://www.card-gorilla.com/search/card?cate=CRD"; // 신용카드
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.lst_more")));
                WebElement lstMoreElement = driver.findElement(By.cssSelector("a.lst_more"));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", lstMoreElement);
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("[No lst More]");

        List<Card> cardList = new ArrayList<>();

        for (WebElement cardContainer : driver.findElements(By.cssSelector("div.card-container"))) {

            WebElement imageContainer = cardContainer.findElement(By.cssSelector("div.card_img p.img img"));
            String imageUrl = imageContainer.getAttribute("src");

            WebElement cardNameElement = cardContainer.findElement(By.cssSelector("div.card_data span.card_name"));
            String cardName = cardNameElement.getText();

            WebElement cardCorpElement = cardContainer.findElement(By.cssSelector("div.card_data span.card_corp"));
            String cardCorp = cardCorpElement.getText();

            WebElement lMthElement = cardContainer.findElement(By.cssSelector("div.card_data p.l_mth"));
            String lastMonth = lMthElement.getText();

            WebElement detailElement = cardContainer.findElement(By.cssSelector("div.card_data a.b_view"));
            String detailUrl = detailElement.getAttribute("href");

            WebElement saleElement = cardContainer.findElement(By.cssSelector("div.card_data div.sale"));

            // "KB Pay" 키워드 가져오기
            WebElement storeElement = saleElement.findElement(By.xpath(".//i[@class='store']"));
            String storeKeyword = storeElement.getText();

            // "할인" 텍스트 가져오기
            WebElement discountTextElement = saleElement.findElement(By.xpath(".//span[@class='num']"));
            String discountText = discountTextElement.getText();

            // 할인 항목
            WebElement discountPercentElement = saleElement.findElement(By.xpath(".//b"));
            String discountPercent = discountPercentElement.getText();

            String benefitKeyword = storeKeyword + " : " + discountText + " : " + discountPercent;

            String notification = "";
            cardList.add(new Card(imageUrl,cardName,cardCorp,null,lastMonth, detailUrl, benefitKeyword, notification));

        }

        for(Card c : cardList){
            System.out.println(c.toString());
        }

        System.out.println("cardList Size --> "+cardList.size());

        driver.quit();

        return cardList;
    }




}
