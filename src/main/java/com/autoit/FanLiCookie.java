package com.autoit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


/**
 * Created by summe on 2017/5/30.
 */
public class FanLiCookie {
    private WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.31\\chromedriver.exe");
    }

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.out.println("=========开始执行===============");


    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }

    @Test
    public void aSaveCookieTest() {
        driver.get("https://passport.fanli.com/login");


        if (!driver.findElement(By.className("login-form")).isDisplayed())
            driver.findElement(By.cssSelector("ul.login-tab>li:last-child ")).click();


        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement user = wait.until(visibilityOfElementLocated(By.id("username")));
        user.clear();
        user.sendKeys("18217410309");

        WebElement passwd = driver.findElement(By.id("psw"));
        passwd.clear();
        passwd.sendKeys("234718@fanli");

        WebElement aCooklogin = driver.findElement(By.id("cooklogin"));

        if (!aCooklogin.isSelected())
            aCooklogin.click();

        driver.findElement(By.id("btn-login")).click();

        wait.until(presenceOfElementLocated(By.id("side-menu")));
        writeCookie(driver, "fanli.cookie.txt");

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshort1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test(invocationCount = 1)
    public void bReadCookieTest() {

        driver.get("https://passport.fanli.com/login");

        sleep3s();

        writeCookie(driver, "fanli.cookie1.txt");

        readCookie(driver, "fanli.cookie.txt");

        driver.get("http://www.fanli.com/");

        writeCookie(driver, "fanli.cookie2.txt");

        String chklogin = driver.findElement(By.cssSelector("#J_topbar_chklogin a")).getAttribute("href");

        Assert.assertTrue(chklogin.contains("/center/welcome"), "免登录失败");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshort1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        System.out.println("=====END====");
    }


    public void writeCookie(WebDriver driver, String filename) {
        File cookieFile = new File(filename);
        BufferedWriter bufferedWriter = null;
        try {
            if (cookieFile.exists())
                cookieFile.delete();
            cookieFile.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(cookieFile));

            for (Cookie cookie : driver.manage().getCookies()) {

                Date date = cookie.getExpiry();
                String exp = null;
                if (date != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                    exp = sdf.format(date);
                }

                bufferedWriter.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" +
                        cookie.getPath() + ";" + exp + ";" + cookie.isSecure()));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void readCookie(WebDriver driver, String filename) {

        File cookieFile = new File(filename);
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(cookieFile));
            String line;
            while ((line = bufReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                while (stringTokenizer.hasMoreTokens()) {
                    String name = stringTokenizer.nextToken();
                    String value = stringTokenizer.nextToken();
                    String domain = stringTokenizer.nextToken();
                    String path = stringTokenizer.nextToken();
                    String dt = stringTokenizer.nextToken();
                    Date expiry = null;
                    if (!dt.equals("null")) {
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                        df.setTimeZone(TimeZone.getTimeZone("UTC"));
                        expiry = df.parse(dt);
                    }
                    boolean isSecure = Boolean.parseBoolean(stringTokenizer.nextToken());
                    Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    driver.manage().addCookie(cookie);
                }
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufReader != null)
                    bufReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sleep3s() {
        sleep3s(3000);
    }

    public static void sleep3s(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollTo(WebDriver driver, int ypos) {
        scrollTo(driver, 0, ypos);
    }

    public static void scrollTo(WebDriver driver, int xpos, int ypos) {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }


}
