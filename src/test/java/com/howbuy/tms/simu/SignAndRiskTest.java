package com.howbuy.tms.simu;

import com.howbuy.simu.InvestorSignPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 风险测评
 * Created by yang.zhou on 2017/11/6.
 */
public class SignAndRiskTest extends BaseTestCase {


    @Test
    public void signAndRiskTest() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199101016413");
    }

    @Test
    public void signAndRiskTest00() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198901017583");
    }


    @Test
    public void signAndRiskTest01() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197401019721");
    }

    @Test
    public void signAndRiskTest02() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198501013276");
    }

    @Test
    public void signAndRiskTest03() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("32010119790101170X");
    }

    @Test
    public void signAndRiskTest04() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101197101013782");
    }

    @Test
    public void signAndRiskTest05() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198401019216");
    }

    @Test
    public void signAndRiskTest06() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("32010119940101214X");
    }

    @Test
    public void signAndRiskTest07() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199601014289");
    }

    @Test
    public void signAndRiskTest08() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101198901017575");
    }

    @Test
    public void signAndRiskTest09() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("320101199301015407");
    }


}