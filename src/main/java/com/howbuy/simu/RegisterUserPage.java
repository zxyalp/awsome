package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

/**
 * @author yang.zhou
 * @date 2018/1/9
 */
public class RegisterUserPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(RegisterUserPage.class);

    private String registerPath = "/trade/register/register.htm";


    /**
     * 身份证号码
     */
    @FindBy(id = "certNo")
    private WebElement certNoInput;

    /**
     * 真实姓名
     */
    @FindBy(id = "custName")
    private WebElement custNameInput;

    /**
     * 联系地址
     */
    @FindBy(id = "address")
    private WebElement addressInput;

    /**
     * 手机号码
     */
    @FindBy(id = "mobile")
    private WebElement mobileInput;

    /**
     * 短信验证码
     */
    @FindBy(id = "phoneidentify")
    private WebElement identifyInput;

    /**
     * 获取短信验证码
     */
    @FindBy(css = "input[value='获取验证码']")
    private WebElement identifyBtn;

    /**
     * 验证码输入框
     */
    @FindBy(css = "#idPop_getcode input")
    private WebElement codeInput;


    /**
     * 确认
     */
    @FindBy(css = "#idPop_getcode a[onclick*='verifyCaptcha']")
    private WebElement verifyBtn;


    /**
     * 验证码图片
     */
    @FindBy(id = "checkCodeImg")
    private WebElement checkCodeImg;

    /**
     * 登录密码
     */
    @FindBy(id = "loginPwd")
    private WebElement loginPwdInput;

    /**
     * 确认登录密码
     */
    @FindBy(id = "reLoginPwd")
    private WebElement reLoginPwdInput;

    /**
     * 交易密码
     */
    @FindBy(id = "txPwd")
    private WebElement txPwdInput;

    /**
     * 确认交易密码
     */
    @FindBy(id = "reTxPwd")
    private WebElement reTxPwdInput;

    /**
     * 确认提交
     */
    @FindBy(id = "submitBn")
    private WebElement submitBn;


    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    @Override
    public void open() {
        super.open(15080, registerPath);
    }

    /**
     * 免费开户
     *
     * @param certNo   身份证号码
     * @param custName 姓名
     * @param address  联系地址
     * @param mobile   手机号码
     * @param identify 短信验证码
     * @param loginPwd 登录密码
     * @param txPwd    交易密码
     */
    public void createNewUser(String certNo, String custName, String address, String mobile, String identify, String loginPwd, String txPwd) {

        try {
            certNoInput.sendKeys(certNo);
            custNameInput.sendKeys(custName);
            addressInput.sendKeys(address);
            mobileInput.sendKeys(mobile);
            identifyInput.sendKeys(identify);
            TestUtils.sleep1s();
            identifyBtn.click();
            TestUtils.sleep1s();
            codeInput.sendKeys("1111");
            TestUtils.sleep1s();
            verifyBtn.click();

            // 登录密码
            TestUtils.scrollTo(driver, loginPwdInput.getLocation().getY());
            loginPwdInput.sendKeys(loginPwd);
            reLoginPwdInput.sendKeys(loginPwd);

            // 交易密码
            txPwdInput.sendKeys(txPwd);
            reTxPwdInput.sendKeys(txPwd);
            TestUtils.sleep1s();
            submitBn.click();
        } catch (NoSuchElementException n) {
            throw new RuntimeException("PC网站免费开户失败.", n);
        }

    }


    /**
     * 默认设置验证码、登录密码、交易密码
     */
    public void createNewUser(String certNo, String custName, String mobile) {
        createNewUser(certNo, custName, "该用户为自动化开户", mobile, "111111",
                "qq1111", "121212");
    }


    private static String getCodeImg() {

        File file = new File("D://data//1.jpeg");

        InputStream in = null;
        OutputStream out = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();


        try {

            HttpGet httpGet = new HttpGet("http://192.168.221.123:15080/trade/captcha.htm?t=1515562467630");

            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/60.0.3112.113 Safari/537.36");

            CloseableHttpResponse response1 = httpClient.execute(httpGet);

            HttpEntity entity = response1.getEntity();

            in = entity.getContent();

            out = new FileOutputStream(file);

            int len;

            byte[] buffer = new byte[1024];

            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }

            EntityUtils.consume(entity);

        } catch (ClientProtocolException c) {
            c.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        Tesseract tess = new Tesseract();
        tess.setDatapath("D:\\data");
        String result = null;
        try {
            result = tess.doOCR(file);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public static void main(String[] args) {
        HttpHost httpHost = new HttpHost("192.168.221.121");
        HttpHost httpHost1 = HttpHost.create("192.168.221.123");

        HttpHost httpHost2 = null;
        try {
            httpHost2 = (HttpHost) httpHost.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(httpHost2.toURI());
        System.out.println(httpHost2.toHostString());

    }

}
