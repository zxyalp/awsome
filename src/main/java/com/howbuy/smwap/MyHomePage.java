package com.howbuy.smwap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 我的私募首页
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public class MyHomePage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(MyHomePage.class.getName());


    @FindBy(id = "loading")
    private WebElement loading;

    @FindBy(id = "dialogMain")
    private WebElement dialog;

    @FindBy(linkText = "买私募")
    private WebElement buyListLink;

    @FindBy(linkText = "卖私募")
    private WebElement sellListLnk;

    @FindBy(linkText = "我的预约")
    private WebElement orderLink;

    @FindBy(linkText = "交易记录")
    private WebElement recordListLink;


    public MyHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void clickBuyList() {
        wait.until(visibilityOf(buyListLink)).click();
    }

    public void clickSellList() {
        wait.until(visibilityOf(sellListLnk)).click();
    }

    public void clickRecordList() {
        wait.until(visibilityOf(recordListLink)).click();
    }


}
