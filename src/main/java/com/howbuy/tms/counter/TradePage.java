package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * @author yang.zhou
 * @date 2017/9/11
 */
public class TradePage {

    private final Logger logger = LoggerFactory.getLogger(TradePage.class.getName());

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(xpath = "//dt[contains(text(), '高端业务')]")
    private WebElement highMenu;

    @FindBy(xpath = "//dt[contains(text(), '交易下单')]")
    private WebElement tradeMenu;

    @FindBy(how = How.LINK_TEXT, using = "认申购")
    private WebElement buyMenu;

    @FindBy(how = How.LINK_TEXT, using = "赎回")
    private WebElement sellMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='buy.html']")
    private WebElement buyFrame;

    @FindBy(how = How.CSS, using = "iframe[src*='sell.html']")
    private WebElement sellFrame;


    public TradePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void get(String url, String operatorNo) {
        driver.get(url + "?operatorNo=" + operatorNo);
        driver.manage().window().maximize();
    }

    public void queryCustName(String custNo, String idNo, WebElement menu, WebElement frame) {
        (wait.until(visibilityOf(highMenu))).click();
        (wait.until(visibilityOf(tradeMenu))).click();
        (wait.until(visibilityOf(menu))).click();
        WebElement iFrame = wait.until(visibilityOf(frame));
        driver.switchTo().frame(iFrame);
        QueryUserPage queryUserPage = PageFactory.initElements(driver, QueryUserPage.class);
        if (custNo != null) {
            queryUserPage.queryByCustNo(custNo);
        }
        if (idNo != null) {
            queryUserPage.queryByIdNo(idNo);
        }
    }

    public void queryCustNoToBuy(String custNo) {
        queryCustName(custNo, null, buyMenu, buyFrame);
    }

    public void queryCustNoToSell(String custNo) {
        queryCustName(custNo, null, sellMenu, sellFrame);
    }

    public void queryIdNoToBuy(String idNo) {
        queryCustName(null, idNo, buyMenu, buyFrame);
    }

    public void queryIdNoToSell(String idNo) {
        queryCustName(null, idNo, sellMenu, sellFrame);
    }


    public void buy(String fundCode, String applyAmount, String appTm, int index) {
        TestUtils.scrollTo(driver, 10000);
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyOrderForm(fundCode, applyAmount, appTm, index);
    }

    public void buy(String fundCode, String applyAmount, String appTm) {
        buy(fundCode, applyAmount, appTm, 1);
    }

    public void sell(String fundCode, String appVol, String appTm) {
        TestUtils.scrollTo(driver, 10000);
        SellPage sellPage = PageFactory.initElements(driver, SellPage.class);
        sellPage.sellOrderForm(fundCode, appVol, appTm);
    }

}
