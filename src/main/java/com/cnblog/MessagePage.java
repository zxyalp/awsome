package com.cnblog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by summe on 2017/5/29.
 */
public class MessagePage {

    private Wait<WebDriver> wait;
    private WebDriver driver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "短消息")
    WebElement shortMsgLink;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "撰写新短消息")
    WebElement newMsgLink;

    @FindBy(how = How.LINK_TEXT, using = "发件箱")
    WebElement outboxLink;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "收件箱")
    WebElement inboxLink;

    private final Logger logger = LoggerFactory.getLogger(MessagePage.class);

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    public void toMessagePage() {
        shortMsgLink = wait.until(visibilityOf(shortMsgLink));
        shortMsgLink.click();
    }

    public void toOutboxPage() {
        outboxLink = wait.until(visibilityOf(outboxLink));
        outboxLink.click();
    }

    public void createMsg(String incept, String title, String content) {
        newMsgLink.click();

        logger.info("create a message.");
        CreateblogPage createblogPage = PageFactory.initElements(driver, CreateblogPage.class);
        createblogPage.createMsg(incept, title, content);

    }

    public void delFirstMsg() throws InterruptedException {
        toOutboxPage();

        OutboxPage outboxPage = PageFactory.initElements(driver, OutboxPage.class);
        outboxPage.delFirstMsg();
    }

    public void delAllMsg() {
        toOutboxPage();

        OutboxPage outboxPage = PageFactory.initElements(driver, OutboxPage.class);
        outboxPage.delAllMsg();
    }

}
