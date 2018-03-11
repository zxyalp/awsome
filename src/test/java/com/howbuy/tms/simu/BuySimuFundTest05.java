package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 非预约申购产品
 * S33873，S62866，S36248，S37842
 * <p>
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest05 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest05.class);


    /**
     * 非预约申购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100199401019590", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S37842", randomMillAmount(1, 3));
    }


    /**
     * 非预约申购+单张银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("33010019810101104X", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 自划款下单
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S37842", randomMillAmount(1, 3));
    }


    /**
     * 非预约申购+多卡银行卡代扣下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser05() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197501016160", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S37842", randomMillAmount(1, 3));

        // 卡2代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyHighFund("S37842", randomMillAmount(1, 3), 2);
    }


    /**
     * 非预约申购+多卡银行卡自划款下单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser06() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197201014796", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1自划款
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S37842", randomMillAmount(1, 3));

        // 卡2自划款
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S36248", randomMillAmount(1, 3), 2);
        highEndBuyPage.buyBankLinePay("S37842", randomMillAmount(1, 3), 2);
    }

    /**
     * 非预约申购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser07() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197001018450", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
    }

    /**
     * 非预约申购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser08() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100197301011592", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
    }


    /**
     * 非预约申购+单张银行卡代扣下单，银行卡限额300万
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser09() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100198101013176", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
    }
}
