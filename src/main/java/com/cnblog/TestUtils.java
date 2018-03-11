package com.cnblog;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


/**
 * Created by summe on 2017/5/29.
 */
public class TestUtils {

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

    public static void scrollTo(WebDriver driver, int xpos, int ypos) {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }

}
