package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 购买私募产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest01 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest01.class);


    /**
     * 开放日最后一天预约自划款 S29493 S29837
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197301011503", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29493", "5500000");
        highEndBuyPage.buyHighFund("S29493", "5600000");

    }

    /**
     * 开放日最后一天预约自划款 S29493 S29837
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119980101278X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S21582", "1600000");
        highEndBuyPage.buyHighFund("S21582", "1700000");
        highEndBuyPage.buyHighFund("S22275", "1600000");
        highEndBuyPage.buyHighFund("S22275", "1700000");

    }


    /**
     * 非预约
     */

    @Test(enabled = true)
    public void loginSimuUser15() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197601016066", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29494", "2100000");
        highEndBuyPage.buyHighFund("S29494", "2500000");
        highEndBuyPage.buyHighFund("S29494", "2500000");

    }

    /**
     * 非预约
     */

    @Test(enabled = true)
    public void loginSimuUser16() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101016798", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("S33873", "2100000");
        highEndBuyPage.buyHighFund("S33873", "2500000");
        highEndBuyPage.buyHighFund("S33873", "2400000");

    }


}
