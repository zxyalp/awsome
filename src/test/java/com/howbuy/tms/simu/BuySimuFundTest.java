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
public class BuySimuFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest.class);

    /**
     * 购买所有认购产品
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101016798", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("P11601", "1000000");
        highEndBuyPage.buyHighFund("P12596", "1000000");
        highEndBuyPage.buyHighFund("P24761", "5000000");
        highEndBuyPage.buyHighFund("S21582", "1000000");
        highEndBuyPage.buyHighFund("S22275", "1000000");

    }

    /**
     * 购买所有申购产品
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198301013802", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", "1000000");
        highEndBuyPage.buyHighFund("S29089", "1000000");
        highEndBuyPage.buyHighFund("S29129", "1000000");
        highEndBuyPage.buyHighFund("S29387", "5000000");
        highEndBuyPage.buyHighFund("S33873", "1000000");
        highEndBuyPage.buyHighFund("S29493", "1000000");
        highEndBuyPage.buyHighFund("S33873", "1000000");
        highEndBuyPage.buyHighFund("S62866", "1000000");
        highEndBuyPage.buyHighFund("S62866", "1000000");
    }

    /**
     * 预约认购	P11601 单卡代扣
     *
     * @throws Exception
     */
    @Test(enabled = false)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198801017156", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("P11601", "1000000");
        highEndBuyPage.buyHighFund("P11601", "2000000");
    }

    /**
     * 预约认购	P11601 单卡自划款
     *
     * @throws Exception
     */
    @Test(enabled = false)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101017782", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("P11601", "3100000", 2);
        highEndBuyPage.buyHighFund("P11601", "5000000", 2);
    }


    /**
     * 预约认购	P12596  P24761 多卡代扣
     *
     * @throws Exception
     */
    @Test(enabled = false)
    public void loginSimuUser05() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101019323", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("P12596", "3100000");
        highEndBuyPage.buyHighFund("P12596", "3200000");
        highEndBuyPage.buyHighFund("P12596", "2100000", 2);
        highEndBuyPage.buyHighFund("P12596", "2200000", 2);

        highEndBuyPage.buyHighFund("P24761", "3100000");
        highEndBuyPage.buyHighFund("P24761", "2400000");
        highEndBuyPage.buyHighFund("P24761", "1100000", 2);
        highEndBuyPage.buyHighFund("P24761", "2400000", 2);
    }


    /**
     * 预约认购	P11601 多卡自划款
     *
     * @throws Exception
     */
    @Test(enabled = false)
    public void loginSimuUser06() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198401019582", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("P11601", "5100000");
        highEndBuyPage.buyHighFund("P11601", "5400000");
        highEndBuyPage.buyHighFund("P11601", "3100000", 2);
        highEndBuyPage.buyHighFund("P11601", "3400000", 2);
    }

    /**
     * 非预约认购	S21582 单卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser07() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199101016798", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S21582", "1100000");
        highEndBuyPage.buyHighFund("S21582", "2200000");
    }


    /**
     * 非预约认购	S22275 单卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser08() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198701012817", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S22275", "3200000");
//        highEndBuyPage.buyHighFund("S22275", "3200000");
    }


    /**
     * 非预约认购	S21582 多卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser09() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197601014677", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S21582", "2100000");
        highEndBuyPage.buyHighFund("S21582", "2100000");
        highEndBuyPage.buyHighFund("S21582", "1100000", 2);
        highEndBuyPage.buyHighFund("S21582", "1100000", 2);
    }


    /**
     * 非预约认购	S22275 多卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser10() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198701012956", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S22275", "5100000");
        highEndBuyPage.buyHighFund("S22275", "5100000");
        highEndBuyPage.buyHighFund("S22275", "3100000", 2);
        highEndBuyPage.buyHighFund("S22275", "3100000", 2);
    }

    /**
     * 预约申购	S28646 S29089 单卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser11() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199401019771", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", "1100000");
        highEndBuyPage.buyHighFund("S28646", "1500000");

        highEndBuyPage.buyHighFund("S29089", "2100000");
        highEndBuyPage.buyHighFund("S29089", "2600000");
    }

    /**
     * 预约申购	S29129 S29387 单卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser12() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197301011503", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", "3800000");
        highEndBuyPage.buyHighFund("S28646", "3500000");

        highEndBuyPage.buyHighFund("S29089", "4100000");
        highEndBuyPage.buyHighFund("S29089", "4600000");
    }


    /**
     * 预约申购	S28646 S29089 多卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser13() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198801019370", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", "3100000");
        highEndBuyPage.buyHighFund("S28646", "3500000");
        highEndBuyPage.buyHighFund("S28646", "2100000", 2);
        highEndBuyPage.buyHighFund("S28646", "2500000", 2);

        highEndBuyPage.buyHighFund("S29089", "4100000");
        highEndBuyPage.buyHighFund("S29089", "4600000");
        highEndBuyPage.buyHighFund("S29089", "1100000", 2);
        highEndBuyPage.buyHighFund("S29089", "1600000", 2);
    }


    /**
     * 预约申购	S29129 S29387 多卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser14() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119980101278X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", "5100000");
        highEndBuyPage.buyHighFund("S28646", "5500000");
        highEndBuyPage.buyHighFund("S28646", "3100000", 2);
        highEndBuyPage.buyHighFund("S28646", "3500000", 2);

        highEndBuyPage.buyHighFund("S29089", "6100000");
        highEndBuyPage.buyHighFund("S29089", "6600000");
        highEndBuyPage.buyHighFund("S29089", "3100000", 2);
        highEndBuyPage.buyHighFund("S29089", "3600000", 2);
    }


    /**
     * 非预约申购	S33873 S62866 单卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser15() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119850101165X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", "2100000");
        highEndBuyPage.buyHighFund("S33873", "2500000");

        highEndBuyPage.buyHighFund("S62866", "2100000");
        highEndBuyPage.buyHighFund("S62866", "2600000");
    }


    /**
     * 非预约申购	 S37842 单卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser16() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197601016066", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S37842", "4100000");
        highEndBuyPage.buyHighFund("S37842", "4500000");
    }


    /**
     * 非预约申购	S33873 S62866 多卡代扣
     */

    @Test(enabled = false)
    public void loginSimuUser17() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198501014332", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", "2500000");
        highEndBuyPage.buyHighFund("S33873", "2500000");
        highEndBuyPage.buyHighFund("S33873", "1800000", 2);
        highEndBuyPage.buyHighFund("S33873", "1800000", 2);

        highEndBuyPage.buyHighFund("S62866", "2200000");
        highEndBuyPage.buyHighFund("S62866", "2200000");
        highEndBuyPage.buyHighFund("S62866", "1400000", 2);
        highEndBuyPage.buyHighFund("S62866", "1400000", 2);
    }


    /**
     * 非预约申购	 S37842 多卡自划款
     */

    @Test(enabled = false)
    public void loginSimuUser18() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119980101286X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S37842", "5500000");
        highEndBuyPage.buyHighFund("S37842", "5500000");
        highEndBuyPage.buyHighFund("S33873", "3800000", 2);
        highEndBuyPage.buyHighFund("S33873", "3800000", 2);
    }


    /**
     * 预约认购	P12596  P24761 储蓄罐
     */
    @Test(enabled = false)
    public void loginSimuUser19() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198801018159", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyPiggyPay("P12596", "2500000");
        highEndBuyPage.buyPiggyPay("P12596", "1500000");
        highEndBuyPage.buyPiggyPay("P24761", "1800000");
        highEndBuyPage.buyPiggyPay("P24761", "1800000");
    }

    /**
     * 非预约认购	S21582 储蓄罐
     */
    @Test(enabled = false)
    public void loginSimuUser20() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101199501012550", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyPiggyPay("S21582", "2500000");
        highEndBuyPage.buyPiggyPay("S21582", "1500000");
    }


    /**
     * 预约申购	S28646 S29089 储蓄罐
     */
    @Test(enabled = false)
    public void loginSimuUser21() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197901013684", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyPiggyPay("S28646", "2500000");
        highEndBuyPage.buyPiggyPay("S28646", "1500000");
        highEndBuyPage.buyPiggyPay("S29089", "1800000");
        highEndBuyPage.buyPiggyPay("S29089", "2800000");
    }


    /**
     * 非预约申购	S33873 S62866 储蓄罐
     */
    @Test(enabled = false)
    public void loginSimuUser22() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198901018228", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyPiggyPay("S33873", "2500000");
        highEndBuyPage.buyPiggyPay("S33873", "1500000");
        highEndBuyPage.buyPiggyPay("S62866", "1800000");
        highEndBuyPage.buyPiggyPay("S62866", "2800000");
    }
}
