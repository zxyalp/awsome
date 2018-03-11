package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 预约申购产品
 * S28646，S29089，S29129，S29387
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest04 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest04.class);

    /**
     * 购买所有申购产品
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197301014961", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        // 预约申购
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29129", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29387", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29493", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29494", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29837", randomMillAmount(1, 3));

        // 非预约申购
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S37842", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S38010", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S38011", randomMillAmount(1, 3));
    }


    /**
     * 预约申购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197401013106", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29129", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29387", randomMillAmount(1, 3));
    }


    /**
     * 预约申购+单张银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100198401014429", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 自划款下单
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29129", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29387", randomMillAmount(1, 3));
    }


    /**
     * 预约申购+多卡银行卡代扣下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser05() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100199601013038", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29129", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29387", randomMillAmount(1, 3));

        // 卡2代扣
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S29129", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S29387", randomMillAmount(1, 3), 2);
    }


    /**
     * 预约申购+多卡银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser06() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197201012600", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29129", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29387", randomMillAmount(1, 3));

        // 卡2代扣
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S29129", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S29387", randomMillAmount(1, 3), 2);
    }


}
