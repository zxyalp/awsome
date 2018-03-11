package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 非预约认购产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest03 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest03.class);


    /**
     * 非预约认购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = false)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197101019602", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21955", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S22275", randomMillAmount(1, 3));
    }


    /**
     * 非预约认购+单张银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197001015778", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 自划款下单
        highEndBuyPage.buyBankLinePay("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21955", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S22275", randomMillAmount(1, 3));
    }


    /**
     * 非预约认购+多卡银行卡代扣下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser05() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100198701011609", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyHighFund("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21955", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S22275", randomMillAmount(1, 3));

        // 卡2代扣
        highEndBuyPage.buyHighFund("PE0146", randomMillAmount(1, 5), 2);
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 5), 2);
        highEndBuyPage.buyHighFund("S21955", randomMillAmount(1, 5), 2);
        highEndBuyPage.buyHighFund("S22275", randomMillAmount(1, 5), 2);
    }


    /**
     * 非预约认购+多卡银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser06() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("33010019720101784X", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyBankLinePay("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21955", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S22275", randomMillAmount(1, 3));

        // 卡2代扣
        highEndBuyPage.buyBankLinePay("PE0146", randomMillAmount(1, 7), 2);
        highEndBuyPage.buyBankLinePay("S21582", randomMillAmount(1, 7), 2);
        highEndBuyPage.buyBankLinePay("S21955", randomMillAmount(1, 7), 2);
        highEndBuyPage.buyBankLinePay("S22275", randomMillAmount(1, 7), 2);
    }


}
