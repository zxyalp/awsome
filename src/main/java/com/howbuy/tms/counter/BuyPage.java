package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import com.howbuy.tms.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * 1、购买页面
 *
 * @author yang.zhou
 * @date 2017/9/11
 */
public class BuyPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(BuyPage.class.getName());


    /**
     * 基金代码
     */
    @FindBy(id = "fundCode")
    @CacheLookup
    private WebElement fundCodeText;

    /**
     * 基金名称
     */
    @FindBy(id = "fundName")
    @CacheLookup
    private WebElement fundNameText;

    /**
     * 基金代码搜索放大镜
     */
    @FindBy(className = "searchIcon")
    @CacheLookup
    private WebElement searchIcon;

    /**
     * 申请金额
     */
    @FindBy(id = "applyAmount")
    @CacheLookup
    private WebElement applyAmountElement;

    /**
     * 获取银行卡
     */
    @FindBy(css = "#selectBank > option")
    private List<WebElement> selectBankValues;

    /**
     * 银行卡
     */
    @FindBy(css = "#selectBank")
    private WebElement selectBank;

    /**
     * 申请时间
     */
    @FindBy(id = "appTm")
    @CacheLookup
    private WebElement appTmElement;

    /**
     * 提交按钮
     */
    @FindBy(id = "confimBuyBtn")
    @CacheLookup
    private WebElement confimBuyBtn;


    @FindBy(css = ".layui-layer-btn0")
    private WebElement okBtn;


    public BuyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void buyOrderForm(String fundCode, String applyAmount, String appTm) {
        buyOrderForm(fundCode, applyAmount, appTm, 1);
    }

    public void buyOrderForm(String fundCode, String applyAmount, String appTm, int index) {
        TestUtils.sleep3s();
        fundCodeText = wait.until(visibilityOf(fundCodeText));
        fundCodeText.clear();
        fundCodeText.sendKeys(fundCode);
        TestUtils.sleep1s();
        searchIcon.click();
        TestUtils.sleep1s();
        applyAmountElement.clear();
        applyAmountElement.sendKeys(applyAmount);
        TestUtils.sleep1s();
        selectBank(index);
        TestUtils.sleep1s();
        appTmElement.clear();
        appTmElement.sendKeys(appTm);
        TestUtils.sleep1s();
        submit();
    }

    private void submit() {
        confimBuyBtn.click();
        wait.until(visibilityOf(okBtn)).click();
    }

    private void selectBank(int i) {
        if (selectBankValues.size() > 1) {
            selectBank.click();
            selectBankValues.get(i - 1).click();
        }
    }

    public void orderInfo(String fundCode, String applyAmount) {
        buyOrderForm(fundCode, applyAmount, "090000");
    }

}
