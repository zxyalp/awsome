package com.howbuy.tms;

import com.howbuy.common.TestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * TestBaseCase
 * Created by yang.zhou on 2017/11/6.
 */
public class BaseTestCase {
    private final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);

    protected WebDriver driver;


    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", TestContext.CHROME_DRIVER_PATH);
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        logger.info("关闭浏览器.");
//        driver.quit();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        logger.info("==========测试结束==========");
    }

    public static int getRandom(int min, int max) {
        return (int) (min + Math.random() * (Math.abs(max - min) + 1));
    }

    /**
     * 生成随机的百万金额
     *
     * @param minAmount 最小金额，单位：百万
     * @param maxAmount 最大金额，单位：百万
     * @return
     */
    public static String randomMillAmount(int minAmount, int maxAmount) {
        return String.valueOf(getRandom(minAmount * 100, maxAmount * 100) * 10000);
    }

    public static String randomAmount(int minAmount, int maxAmount) {
        return String.valueOf(getRandom(minAmount, maxAmount) * 10000);
    }

}
