package com.howbuy.smwap;

import com.howbuy.common.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 购买下单
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public class BuyFundPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(BuyFundPage.class);


    public BuyFundPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void buy(String fundCode, String amount, int index, PaymentType paymentType) {

        SearchFundPage searchFundPage = PageFactory.initElements(driver, SearchFundPage.class);
        searchFundPage.searchFund(fundCode);

        PayInfoPage payInfoPage = PageFactory.initElements(driver, PayInfoPage.class);
        payInfoPage.pay(amount, index, paymentType);

    }


    /**
     * 使用银行卡代扣
     */
    public void buy(String fundCode, String amount, int index) {
        buy(fundCode, amount, index, PaymentType.BANK_CARD_PAY);
    }

    /**
     * 默认使用第一张银行卡
     */
    public void buy(String fundCode, String amount) {
        buy(fundCode, amount, 1);
    }

    /**
     * 银行转账支付
     */
    public void buyBankLinePay(String fundCode, String amount, int index) {
        buy(fundCode, amount, index, PaymentType.BANK_LINE_PAY);
    }

    /**
     * 银行转账支付，默认使用第一张银行卡
     */
    public void buyBankLinePay(String fundCode, String amount) {
        buy(fundCode, amount, 1);
    }

    /**
     * 使用储蓄罐支付
     */
    public void buyPiggyPay(String fundCode, String amount, int index) {
        buy(fundCode, amount, index, PaymentType.CXG_PAY);
    }

    /**
     * 默认使用储蓄罐第一张卡支付
     */
    public void buyPiggyPay(String fundCode, String amount) {
        buy(fundCode, amount, 1);
    }

}
