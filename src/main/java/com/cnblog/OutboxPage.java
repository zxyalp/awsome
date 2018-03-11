package com.cnblog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by summe on 2017/5/29.
 */
public class OutboxPage {

    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(how = How.NAME, using = "chkID")
    WebElement chkID;

    @FindBy(how = How.ID, using = "chkSelAll")
    WebElement chkAllID;

    @FindBy(how = How.ID, using = "btnBatDel")
    WebElement delBtn;

    private final Logger logger = LoggerFactory.getLogger(OutboxPage.class);


    public OutboxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public void delFirstMsg() {
        logger.info("delete first message.");
        delMsg(chkID);
    }

    public void delAllMsg() {
        logger.info("delete all messages.");
        delMsg(chkAllID);
    }

    public void delMsg(WebElement chkElement) {

        try {
            wait.until(visibilityOf(chkElement));
            wait.until(visibilityOf(delBtn));
        } catch (TimeoutException e) {
            logger.warn("No messages in Outbox." + e.toString());
            return;
        }
        chkElement.click();
        delBtn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        TestUtils.sleep3s(1000);
        logger.info("delete success.");
    }
}
