package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest03 extends BaseTestCase {
    @Test(enabled = true)
    public void signAndRiskTest1() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("330100197201014796");
    }

    @Test(enabled = true)
    public void signAndRiskTest2() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("330100198901018370");
    }


    @Test(enabled = true)
    public void signAndRiskTest3() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("330100198001017858");
    }

}
