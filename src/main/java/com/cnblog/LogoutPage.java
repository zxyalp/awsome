package com.cnblog;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by summe on 2017/5/29.
 */
public class LogoutPage {

    WebDriver driver;
    Wait<WebDriver> wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }


    public void logout() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}
