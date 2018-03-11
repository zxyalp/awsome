package com.howbuy.simu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yang.zhou
 * @date 2017/9/29
 */
public class OnlineTradePage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(OnlineTradePage.class.getName());

    public OnlineTradePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void buyHighFund(String fundCode, String buyAmount, String txPassword) {
        HighEndBuyPage buyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        buyPage.buyHighFund(fundCode, buyAmount, txPassword);
    }

    public void signAndRiskValuation(String idNo, String password) {
        LoginWebPage loginWebPage = PageFactory.initElements(driver, LoginWebPage.class);
        loginWebPage.login(idNo, password);
        InvestorSignPage signPage = PageFactory.initElements(driver, InvestorSignPage.class);
        signPage.confirmOfInvestors();
    }

    public void signAndRiskValuation(String idNo) {
        signAndRiskValuation(idNo, "qq1111");
    }

}
