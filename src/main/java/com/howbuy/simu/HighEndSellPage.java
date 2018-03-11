package com.howbuy.simu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

/**
 * 在线交易-赎回页面
 *
 * @author yang.zhou
 * @date 2017/10/19
 */
public class HighEndSellPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(HighEndSellPage.class);

    /**
     * 模态框
     */
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    /**
     * 赎回页面菜单
     */
    @FindBy(linkText = "赎回")
    private WebElement sellListLink;

    /**
     * 可赎回列表
     */
    @FindBy(css = "tbody > tr")
    private List<WebElement> sellList;

    public HighEndSellPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public Boolean isRedeemabe(WebElement fund) {
        WebElement redeemLink = fund.findElement(By.linkText("赎回"));
        String aKey = "href";
        String aValue = "sellindex.html";
        if (redeemLink.getAttribute(aKey).contains(aValue)) {
            return true;
        }
        return false;
    }


    public void sell(String fundName) {
        diglog();
    }

    public void diglog() {
        try {
            wait.until(invisibilityOf(dialog));
        } catch (TimeoutException t) {
            logger.info("元素加载超时.", t);
        }
    }

}
