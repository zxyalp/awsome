package com.howbuy.tms.counter;

import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class CheckTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(buyProductByCounterTest.class);

    private String tmsCounterUrl = "http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html";


    @Test
    public void checkOrderTest() throws Exception {
        OrderCheckPage checkPage = PageFactory.initElements(driver, OrderCheckPage.class);
        checkPage.get(tmsCounterUrl, "s002");
        for (; checkPage.size() > 0; ) {
            if (checkPage.isSameOperator())
                checkPage.get(tmsCounterUrl, checkPage.getOtherOperator());
            checkPage.checkFirstOrder();
            checkPage.approvedByOrder();
        }
    }
}
