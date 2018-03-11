package com.autoit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.util.concurrent.TimeUnit;


/**
 * @author summe
 * @date 2017/5/30
 */
public class ChromeOptionsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");


        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();

        ChromeDriverService chromeDriverService = builder.usingDriverExecutable(new File("D:\\selenium\\chromedriver_2.34\\chromedriver.exe")).usingPort(12809).build();
        try {
            chromeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\wb-zy184129\\Desktop\\add\\Postman-Interceptor_v0.2.20.crx"));
        options.addArguments("user-data-dir=C:\\Users\\wb-zy184129\\Desktop\\add\\userfile");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(chromeDriverService, options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://www.tuicool.com/");
        chromeDriverService.stop();

    }

}
