package com.howbuy.smwap;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * login smwap
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public class LoginWapPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(LoginWapPage.class.getName());

    public String loginWapUrl = "/wap/account/login/login.htm";

    /**
     * 登录身份证号码
     */
    @FindBy(id = "displayIdNo")
    private WebElement loginId;

    /**
     * 登录密码
     */
    @FindBy(id = "loginPwd")
    private WebElement loginPwd;

    @FindBy(id = "loginButton")
    private WebElement loginBtn;

    @FindBy(linkText = "免费开户")
    private WebElement freeOpening;


    public LoginWapPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void loginWap(String idNo, String password) {
        open();
        TestUtils.sleep1s();
        loginId = wait.until(ExpectedConditions.visibilityOf(loginId));
        loginId.clear();
        loginId.sendKeys(idNo);
        TestUtils.sleep1s();
        loginPwd.sendKeys(password);
        loginBtn.click();
    }


    public void loginWap(String idNo) {
        loginWap(idNo, "qq1111");
    }


    @Override
    public void open() {
        super.open(4081, loginWapUrl);
    }
}
