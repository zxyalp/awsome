package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 购买专户产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuyHighFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyHighFundTest.class);

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101016413", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("028050", "1000000");
        highEndBuyPage.buyHighFund("028050", "5000000");

        highEndBuyPage.buyHighFund("028051", "1000000");
        highEndBuyPage.buyHighFund("028051", "5000000");

        highEndBuyPage.buyHighFund("060330", "1000000");
        highEndBuyPage.buyHighFund("060330", "5000000");

        highEndBuyPage.buyHighFund("060628", "1000000");
        highEndBuyPage.buyHighFund("060628", "5000000");

        highEndBuyPage.buyHighFund("246010", "1000000");
        highEndBuyPage.buyHighFund("246010", "5000000");

        highEndBuyPage.buyHighFund("246020", "1000000");
        highEndBuyPage.buyHighFund("246020", "5000000");

        highEndBuyPage.buyHighFund("275052", "1000000");
        highEndBuyPage.buyHighFund("275052", "5000000");

        highEndBuyPage.buyHighFund("275807", "1000000");
        highEndBuyPage.buyHighFund("275807", "5000000");


        highEndBuyPage.buyHighFund("371021", "1000000");
        highEndBuyPage.buyHighFund("371021", "5000000");

        highEndBuyPage.buyHighFund("371075", "1000000");
        highEndBuyPage.buyHighFund("371075", "5000000");
    }

    /**
     * 单卡认购	认购028050，028051，代扣2笔、储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest001() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198901017583", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", "2000000");
        highEndBuyPage.buyHighFund("028050", "1500000");
        highEndBuyPage.buyHighFund("028050", "2000000");
        highEndBuyPage.buyHighFund("028051", "2000000");
        highEndBuyPage.buyHighFund("028051", "1200000");

    }

    /**
     * 单卡认购	认购028050，028051，自划款2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest002() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197401019721", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", "3000000");
        highEndBuyPage.buyHighFund("028050", "4000000");
        highEndBuyPage.buyHighFund("028050", "5000000");

        highEndBuyPage.buyHighFund("028051", "2990000");
        highEndBuyPage.buyHighFund("028051", "3000000");
        highEndBuyPage.buyHighFund("028051", "5000000");
    }

    /**
     * 单卡申购	申购246010，246020，代扣2笔，储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest003() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198501013276", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("246010", "1000000");
        highEndBuyPage.buyHighFund("246010", "2200000");
        highEndBuyPage.buyHighFund("246020", "2000000");
        highEndBuyPage.buyHighFund("246020", "1200000");
    }

    /**
     * 单卡申购	申购246010，246020，自划款2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest004() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119790101170X", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("246010", "3100000");
        highEndBuyPage.buyHighFund("246010", "4100000");
        highEndBuyPage.buyHighFund("246010", "5100000");

        highEndBuyPage.buyHighFund("246020", "2990000");
        highEndBuyPage.buyHighFund("246020", "3100000");
        highEndBuyPage.buyHighFund("246020", "5100000");
    }


    /**
     * 多卡认购	认购028050，028051，代扣2笔、储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest005() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197101013782", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", "800000");
        highEndBuyPage.buyHighFund("028050", "900000");
        highEndBuyPage.buyHighFund("028050", "1200000", 2);
        highEndBuyPage.buyHighFund("028050", "2200000", 2);

        highEndBuyPage.buyHighFund("028051", "500000");
        highEndBuyPage.buyHighFund("028051", "900000");
        highEndBuyPage.buyHighFund("028051", "2000000", 2);
        highEndBuyPage.buyHighFund("028051", "2800000", 2);
    }

    /**
     * 多卡认购	认购028050，028051，自划款
     */
    @Test(enabled = true)
    public void buyHighFundTest006() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198401019216", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", "1800000");
        highEndBuyPage.buyHighFund("028050", "1900000");
        highEndBuyPage.buyHighFund("028050", "3200000", 2);
        highEndBuyPage.buyHighFund("028050", "4200000", 2);

        highEndBuyPage.buyHighFund("028051", "1500000");
        highEndBuyPage.buyHighFund("028051", "1900000");
        highEndBuyPage.buyHighFund("028051", "3200000", 2);
        highEndBuyPage.buyHighFund("028051", "3800000", 2);
    }

    /**
     * 多卡申购	申购246010，246020，代扣2笔，储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest007() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119940101214X", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("246010", "800000");
        highEndBuyPage.buyHighFund("246010", "900000");
        highEndBuyPage.buyHighFund("246010", "1200000", 2);
        highEndBuyPage.buyHighFund("246010", "2200000", 2);

        highEndBuyPage.buyHighFund("246020", "500000");
        highEndBuyPage.buyHighFund("246020", "900000");
        highEndBuyPage.buyHighFund("246020", "2000000", 2);
        highEndBuyPage.buyHighFund("246020", "2800000", 2);
    }


    /**
     * 多卡申购	申购246010，246020，自划款2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest008() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199601014289", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("246010", "1800000");
        highEndBuyPage.buyHighFund("246010", "1900000");
        highEndBuyPage.buyHighFund("246010", "3200000", 2);
        highEndBuyPage.buyHighFund("246010", "4200000", 2);

        highEndBuyPage.buyHighFund("246020", "1500000");
        highEndBuyPage.buyHighFund("246020", "1900000");
        highEndBuyPage.buyHighFund("246020", "3200000", 2);
        highEndBuyPage.buyHighFund("246020", "3800000", 2);
    }

    /**
     * 认购028050，028051，储蓄罐2笔
     */

    @Test(enabled = true)
    public void buyHighFundTest009() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198901017575", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyPiggyPay("028050", "1200000");
        highEndBuyPage.buyPiggyPay("028050", "3000000");

        highEndBuyPage.buyPiggyPay("028051", "1000000");
        highEndBuyPage.buyPiggyPay("028051", "3000000");
    }

    /**
     * 申购246010，246020，储蓄罐2笔
     */

    @Test(enabled = true)
    public void buyHighFundTest010() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199301015407", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyPiggyPay("246010", "1200000");
        highEndBuyPage.buyPiggyPay("246010", "3000000");

        highEndBuyPage.buyPiggyPay("246020", "1000000");
        highEndBuyPage.buyPiggyPay("246020", "3000000");
    }
}
