package com.cnblog;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by summe on 2017/5/29.
 */
public class CnblogTest {
    WebDriver driver;

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");
        System.out.println("=========开始执行===============");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }

    @Test
    public void createMsgTest() throws Exception {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openBlog("http://www.cnblogs.com/");
        homePage.login("sesa", "123123p@");

        MessagePage messagePage = PageFactory.initElements(driver, MessagePage.class);
        messagePage.toMessagePage();

        messagePage.createMsg("sesa", "Tes124", "Hello, world124!");
        messagePage.createMsg("sesa", "Tes125", "Hello, world125!");
        messagePage.createMsg("sesa", "Tes126", "Hello, world126!");

        messagePage.delFirstMsg();

        messagePage.delAllMsg();

        homePage.logout();
    }

}
