package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest01 extends BaseTestCase {


    @Test(enabled = false)
    public void signAndRiskTest() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198901012459");

    }

    @Test
    public void signAndRiskTest01() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198901017399");
    }

    @Test
    public void signAndRiskTest02() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199301018931");
    }

    @Test
    public void signAndRiskTest03() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197601016314");
    }

    @Test
    public void signAndRiskTest04() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198401016971");
    }

    @Test
    public void signAndRiskTest05() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199701016775");
    }

    @Test
    public void signAndRiskTest06() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198801013446");
    }

    @Test
    public void signAndRiskTest07() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198501013233");
    }

    @Test
    public void signAndRiskTest08() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199201019603");
    }

    @Test
    public void signAndRiskTest09() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197301014966");
    }

}
