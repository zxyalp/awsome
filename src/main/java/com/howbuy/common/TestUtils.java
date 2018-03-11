package com.howbuy.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author summe
 * @date 2017/5/29
 */
public class TestUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

    private TestUtils() {

    }

    public static void sleep1s() {
        sleep3s(1000);
    }

    public static void sleep2s() {
        sleep3s(2000);
    }

    public static void sleep3s() {
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

    public static void scrollEnd(WebDriver driver) {
        scrollTo(driver, 9999);
    }

    public static void scrollTop(WebDriver driver) {
        scrollTo(driver, 0);
    }

    public static void scrollTo(WebDriver driver, int xpos, int ypos) {
        sleep1s();
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }


    public static void screenshort(WebDriver driver, String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, TestContext.getImageFile(fileName));
        } catch (IOException e) {
            logger.error("保存截图失败.", e);
        }

    }

    public static String matcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(TestContext.getImageFile("test"));
    }
}
