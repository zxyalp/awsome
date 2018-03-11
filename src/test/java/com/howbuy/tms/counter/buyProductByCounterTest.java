package com.howbuy.tms.counter;

import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 中台柜台下单
 * Created by yang.zhou on 2017/11/7.
 */
public class buyProductByCounterTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(buyProductByCounterTest.class);

    private String tmsCounterUrl = "http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html";

    @Test(enabled = false)
    public void buyProductTest() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876230");
        trade.buy("028050", "1200000", "100000");
        trade.buy("028051", "1300000", "100000");
        trade.buy("060330", "1400000", "100000");
        trade.buy("060628", "1500000", "100000");
        trade.buy("246010", "1600000", "100000");
        trade.buy("246020", "1700000", "100000");
        trade.buy("275052", "1800000", "100000");
        trade.buy("275807", "2000000", "100000");
        trade.buy("371021", "2100000", "100000");
        trade.buy("371075", "2200000", "100000");
    }

    @Test(enabled = false)
    public void buyProductTest001() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876228");
        trade.buy("028050", "1200000", "100000");
        trade.buy("028050", "1300000", "100000");
        trade.buy("028051", "1400000", "100000");
        trade.buy("028051", "1500000", "100000");
    }

    @Test(enabled = false)
    public void buyProductTest002() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876210");
        trade.buy("028050", "3200000", "100000");
        trade.buy("028050", "3300000", "100000");
        trade.buy("028051", "3400000", "100000");
        trade.buy("028051", "3500000", "100000");
    }

    @Test(enabled = false)
    public void buyProductTest003() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876207");
        trade.buy("246010", "1200000", "100000");
        trade.buy("246010", "1300000", "100000");
        trade.buy("246020", "1400000", "100000");
        trade.buy("246020", "1500000", "100000");
    }


    @Test(enabled = false)
    public void buyProductTest004() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876195");
        trade.buy("246010", "5200000", "100000");
        trade.buy("246010", "5300000", "100000");
        trade.buy("246020", "5400000", "100000");
        trade.buy("246020", "5500000", "100000");
    }


    @Test(enabled = true)
    public void buyProductTest005() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876180");
        trade.buy("028050", "2200000", "100000");
        trade.buy("028051", "2400000", "100000");

        trade.buy("028050", "2200000", "100000", 2);
        trade.buy("028051", "2400000", "100000", 2);
    }


    @Test(enabled = true)
    public void buyProductTest006() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876156");
        trade.buy("028050", "3200000", "100000");
        trade.buy("028050", "3300000", "100000", 2);
        trade.buy("028051", "3400000", "100000");
        trade.buy("028051", "3500000", "100000", 2);
    }


    @Test(enabled = true)
    public void buyProductTest007() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876147");
        trade.buy("246010", "1200000", "100000");
        trade.buy("246010", "1300000", "100000", 2);
        trade.buy("246020", "1400000", "100000");
        trade.buy("246020", "1500000", "100000", 2);
    }

    @Test(enabled = true)
    public void buyProductTest008() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100876131");
        trade.buy("246010", "3200000", "100000");
        trade.buy("246010", "3300000", "100000", 2);
        trade.buy("246020", "3400000", "100000");
        trade.buy("246020", "3500000", "100000", 2);
    }
}
