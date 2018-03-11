package com.cnblog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;


/**
 * 登录页，输入用户名和密码。
 * Created by summe on 2017/5/29.
 */
public class LoginPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(how = How.ID, using = "input1")
    WebElement usernameText;

    @FindBy(how = How.ID, using = "input2")
    WebElement passwordText;

    @FindBy(how = How.ID, using = "signin")
    WebElement singinBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginBlog(String userName, String passWord) {
        TestUtils.sleep3s(1000);
        usernameText.clear();
        usernameText.sendKeys(userName);
        TestUtils.sleep3s(1000);
        passwordText.clear();
        passwordText.sendKeys(passWord);
        TestUtils.sleep3s(1000);
        singinBtn.click();
        TestUtils.sleep3s(1000);
    }

}
