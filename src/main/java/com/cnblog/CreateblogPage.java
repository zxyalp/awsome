package com.cnblog;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by summe on 2017/5/29.
 */
public class CreateblogPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(how = How.ID, using = "txtIncept")
    WebElement inceptText;

    @FindBy(how = How.ID, using = "txtTitle")
    WebElement titleText;

    @FindBy(how = How.ID, using = "txtContent")
    WebElement contentText;

    @FindBy(how = How.ID, using = "btnSend")
    WebElement sendBtn;


    public CreateblogPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void createMsg(String incept, String title, String content) {
        TestUtils.sleep3s(1000);
        inceptText.sendKeys(incept);
        TestUtils.sleep3s(1000);
        titleText.sendKeys(title);
        TestUtils.sleep3s(1000);
        contentText.sendKeys(content);
        TestUtils.sleep3s(1000);
        sendBtn.click();
        TestUtils.sleep3s(1000);
    }
}

