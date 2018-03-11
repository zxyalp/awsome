package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest02 extends BaseTestCase {


    @Test(enabled = false)
    public void signAndRiskTest() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199001017849");

    }

    @Test
    public void signAndRiskTest01() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198301013802");
    }

    @Test
    public void signAndRiskTest02() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198801017156");
    }

    @Test
    public void signAndRiskTest03() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199101017782");
    }

    @Test
    public void signAndRiskTest04() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199101019323");
    }

    @Test
    public void signAndRiskTest05() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198401019582");
    }

    @Test
    public void signAndRiskTest06() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199101016798");
    }

    @Test
    public void signAndRiskTest07() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198701012817");
    }

    @Test
    public void signAndRiskTest08() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197601014677");
    }

    @Test
    public void signAndRiskTest09() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198701012956");
    }

    @Test
    public void signAndRiskTest10() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199401019771");
    }

    @Test
    public void signAndRiskTest11() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197301011503");
    }

    @Test
    public void signAndRiskTest12() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198801019370");
    }


    @Test
    public void signAndRiskTest13() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("32010119980101278X");
    }

}
