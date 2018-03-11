package com.whatapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


/**
 * Created by yang.zhou on 2017/6/1.
 */
public class LoginDemo {

    private WebDriver driver;


    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }


    @Test
    public void loginTest() {
        driver.get("http://www.yikuyi.com/bom.htm");
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);

        sleep3s();
        WebElement btn = driver.findElement(By.linkText("在线提交"));
        btn.click();

    }

    private static void sleep3s() {
        sleep3s(3000);
    }

    public static void sleep3s(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollTo(WebDriver driver, int ypos) {
        scrollTo(driver, 0, ypos);
    }

    public static void scrollTo(WebDriver driver, int xpos, int ypos) {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }
}
