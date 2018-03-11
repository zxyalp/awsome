package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import com.howbuy.tms.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 赎回页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public class SellPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(SellPage.class.getName());


    /**
     * 基金代码
     */
    @FindBy(id = "fundCode")
    private WebElement fundCodeText;

    /**
     * 基金代码搜索按钮
     */
    @FindBy(className = "searchIcon")
    private WebElement searchIcon;

    /**
     * 当前可用份额
     */
    @FindBy(id = "availVol")
    private WebElement availVolteText;

    /**
     * 冻结份额
     */
    @FindBy(id = "unconfirmedVol")
    private WebElement unconfirmedVolText;

    /**
     * 申请份额
     */
    @FindBy(id = "appVol")
    private WebElement appVolText;

    /**
     * 申请时间
     */
    @FindBy(id = "appTm")
    private WebElement appTmText;

    /**
     * 确认提交
     */
    @FindBy(id = "confimSellBtn")
    private WebElement confimSellBtn;

    /**
     * 无预约确认
     */
    @FindBy(css = ".layui-layer-btn0")
    private WebElement okBtn;


    public SellPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void sellOrderForm(String fundCode, String appVol, String appTm) {
        TestUtils.sleep3s();
        fundCodeText = wait.until(visibilityOf(fundCodeText));
        fundCodeText.clear();
        fundCodeText.sendKeys(fundCode);
        TestUtils.sleep1s();
        searchIcon.click();
        TestUtils.sleep1s();
        appVolText.clear();
        appVolText.sendKeys(appVol);
        TestUtils.sleep1s();
        appTmText.clear();
        appTmText.sendKeys(appTm);
        TestUtils.sleep1s();
        submit();
    }

    private void submit() {
        confimSellBtn.click();
        wait.until(visibilityOf(okBtn)).click();
    }

}
