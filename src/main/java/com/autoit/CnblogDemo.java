package com.autoit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author summe
 * @date 2017/5/29
 */
public class CnblogDemo {
    WebDriver driver;


    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");
        System.out.println("=========开始执行===============");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Test
    public void loginCnblogTest() {
        driver.get("https://passport.cnblogs.com/user/signin");

        WebElement userName = driver.findElement(By.id("input1"));
        userName.clear();
        userName.sendKeys("sesa");

        WebElement password = driver.findElement(By.id("input2"));

        password.clear();
        password.sendKeys("123123p@");

        driver.findElement(By.id("signin")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("消息")));
        msg.click();

//            for (String handle: driver.getWindowHandles())
//                if (!handle.equals(homeHandle)) {
//                    driver.switchTo().window(handle);
//                    break;
//                }

        System.out.println(driver.switchTo().window(driver.getWindowHandle()).getTitle());
        System.out.println(driver.switchTo().window(driver.getWindowHandle()).getCurrentUrl());
        for (String handle : driver.getWindowHandles())
            if (driver.switchTo().window(handle).getCurrentUrl().contains("inbox"))
                break;
        for (int i = 0; i < 1; i++) {
            WebElement compose = wait.until(visibilityOfElementLocated(By.linkText("撰写新短消息")));
            compose.click();
            driver.findElement(By.id("txtIncept")).sendKeys("sesa");
            driver.findElement(By.id("txtTitle")).sendKeys("TestTile" + i);
            driver.findElement(By.id("txtContent")).sendKeys("Hello, world!" + i);
            driver.findElement(By.id("btnSend")).click();
            sleep3s();
        }
        sleep3s();
        driver.findElement(By.linkText("退出")).click();
        sleep3s();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }


    //    @Test
    public void sendMsgTest() {

        driver.get("https://passport.cnblogs.com/user/signin");

        WebElement userName = driver.findElement(By.id("input1"));
        userName.clear();
        userName.sendKeys("sesa");

        WebElement password = driver.findElement(By.id("input2"));
        password.clear();
        password.sendKeys("123123p@");

        driver.findElement(By.id("signin")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement msg = wait.until(visibilityOfElementLocated(By.partialLinkText("消息")));
        msg.click();

//            for (String handle: driver.getWindowHandles())
//                if (!handle.equals(homeHandle)) {
//                    driver.switchTo().window(handle);
//                    break;
//                }

        for (String handle : driver.getWindowHandles())
            if (driver.switchTo().window(handle).getCurrentUrl().contains("inbox"))
                break;

        WebElement compose = wait.until(visibilityOfElementLocated(By.linkText("撰写新短消息")));
        compose.click();

        driver.findElement(By.id("txtIncept")).sendKeys("sesa");
        driver.findElement(By.id("txtTitle")).sendKeys("TestTile");
        driver.findElement(By.id("txtContent")).sendKeys("Hello, world!");
        driver.findElement(By.id("btnSend")).click();


        driver.findElement(By.linkText("发件箱")).click();


        // 第一种，单个勾选所有消息
//        List<WebElement> chksID = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("chkID")));
//
//        for (WebElement chk: chksID){
//            chk.click();
//        }

        // 第二种， 一次勾选所有消息
//        WebElement chkAll = wait.until(visibilityOfElementLocated(By.id("chkSelAll")));
//        chkAll.click();

        // 勾选第一条消息

        wait.until(visibilityOfElementLocated(By.name("chkID"))).click();
        driver.findElement(By.id("btnBatDel")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        WebElement tips = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("opt_tips")));
        for (int i = 1; i < 5; i++) {
            System.out.println(tips.getText());
            if ("删除成功".equals(tips.getText()))
                break;
            sleep3s(i * 1000);
        }
        Assert.assertEquals(tips.getText(), "删除成功");

//        sleep3s();
//        driver.findElement(By.linkText("退出")).click();
//        sleep3s();
//        Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();
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
