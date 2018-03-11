package com.howbuy.tms.counter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyFundTest {

    private WebDriver driver;

    private String tmsCounterUrl = "http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html";

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest.class);

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }

    @Test(priority = 1)
    public void buyProductTest() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100878270");
        trade.buy("246020", "1200000", "093000");
        trade.buy("028051", "1300000", "100000");
        trade.buy("371021", "1400000", "094000");
        trade.buy("028050", "1500000", "100000");
    }

    @Test(enabled = false)
    public void sellVolTest() throws Exception {
        TradePage trade = PageFactory.initElements(driver, TradePage.class);
        trade.get(tmsCounterUrl, "s001");
        trade.queryCustNoToBuy("1100878270");
        trade.sell("028050", "500", "090000");
        trade.sell("028050", "500", "090000");
    }

    @Test(priority = 3)
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

    @AfterClass
    public void tearDown() throws Exception {
        logger.info("==========测试结束==========");
    }

}
