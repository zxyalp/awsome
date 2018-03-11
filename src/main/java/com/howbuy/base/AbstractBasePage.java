package com.howbuy.base;

import com.howbuy.common.UrlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 基础页面
 *
 * @author yang.zhou
 * @date 2017/1/15
 */
public abstract class AbstractBasePage {


    private final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class.getName());

    public int timeOutInSeconds = 12;

    public WebDriver driver;

    public Wait<WebDriver> wait;


    public void get(String url, Dimension dimension) {
        logger.info("访问URL地址：{}", url);
        driver.get(url);
        if (dimension != null) {
            driver.manage().window().setSize(dimension);
        }
        driver.manage().window().maximize();
    }

    public void get(String url) {
        get(url, null);
    }

    public void open(int port, String path) {
        UrlBuilder builder = new UrlBuilder().create();
        builder.setPort(port);
        builder.setPath(path);
        get(builder.toString());
    }

    public void open() {

    }

    public Boolean isElementExist(WebDriver driver, WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
