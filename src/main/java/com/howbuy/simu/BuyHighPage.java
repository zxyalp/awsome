package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.servlets.DataRateLimitedServlet;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


/**高端产品购买页面
 * Created by yang.zhou on 2017/9/29.
 * @author yang.zhou
 */
public class BuyHighPage {

    private static final Log logger = LogFactory.getLog(BuyHighPage.class);

    private WebDriver driver;
    private Wait<WebDriver> wait;

    // 基金代码查询
    @FindBy(id = "searchFund_")
    private WebElement searchFundText;

    // 查询确定按钮
    @FindBy(id = "searchFundBtn_")
    private WebElement searchFundBtn;

    // 数据加载框
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    // 暂无数据元素
    @FindBy(xpath = "//p[text()='暂无数据']")
    private WebElement noFund;

    // 基金购买按钮
    @FindBy(css = "a[href^='buyindex.html']")
    private WebElement  buyIndexBtn;

    // 净购买金额
    @FindBy(id = "buyAmount")
    private WebElement buyAmountText;

    // 选择储蓄罐
    @FindBy(xpath = "//span[text()='储蓄罐']")
    private WebElement savingsBankLink;

    // 选择银行卡
    @FindBy(xpath = "//span[text()='银行卡']")
    private WebElement bankCardLink;

    // 选择线下转账
    @FindBy(xpath = "//span[text()='线下转账']")
    private WebElement offlineTransferLink;

    // 支行名称
    @FindBy(css = "input[data-bind*='bankSubName']")
    private WebElement bankSubNameText;

    // 电子合同签名
    @FindBy(xpath = "//p[text()='电子合同签订']")
    private List<WebElement> signingElecText;

    // 合同复选框
    @FindBy(id = "hetong")
    private WebElement hetongBox;

    // 检查所有合同选项
    @FindBy(id = "all")
    private WebElement allBox;

    // 下一步按钮
    @FindBy(linkText = "下一步")
    private WebElement nextStepBtn;

    // 交易密码
    @FindBy(css = "input[data-bind*='txPassword']")
    private WebElement txPasswordText;

    // 购买确认信息按钮
    @FindBy(linkText = "确认")
    private WebElement nextStepTwoBtn;

    // 手机号码
    @FindBy(css = "input[data-bind*='mobile']")
    private WebElement mobileText;

    // 获取短信验证码
    @FindBy(linkText = "获取短信验证码")
    private WebElement getVerifyCodeBtn;

    // 验证码倒计时
    @FindBy(partialLinkText = "秒")
    private WebElement getVerifyCode;

    // 验证码
    @FindBy(id = "verifyCode")
    private WebElement verifyCodeText;

    // 确认购买
    @FindBy(linkText = "确认购买")
    private WebElement checkVerifyCodeBtn;

    // 购买成功
    @FindBy(xpath = "//p[contains(text(),'您的购买申请已经受理')]")
    private WebElement buyingText;

    private String buyListPage;


    public BuyHighPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void get(){
        driver.get(this.buyListPage);
    }

    public void setBuyListPage(String buyListPage) {
        this.buyListPage = buyListPage;
    }

    public String getBuyListPage() {
        return buyListPage;
    }


    /**
     *查询产品
     * */

    public void queryFund(String fundCode){
        wait.until(invisibilityOf(dialog));
        searchFundText.sendKeys(fundCode);
        TestUtils.sleep1s();
        searchFundBtn.click();
        clickBuyButton();
    }


    /**
     *点击购买按钮
     * */

    public void clickBuyButton(){
        try {
            wait.until(invisibilityOf(dialog));
            buyIndexBtn.click();
        } catch (NoSuchElementException n){
            throw  new RuntimeException("该产品无法购买.");
        }
    }


    /**
     * 1、填写订单
     * @param buyAmount 净购买金额
     * */

    public void fillInOrder(String buyAmount){
        wait.until(invisibilityOf(dialog));
        TestUtils.sleep1s();
        buyAmountText.sendKeys(buyAmount);
        bankCardLink.click();
        TestUtils.scrollEnd(driver);
        bankSubNameText.sendKeys("上海南京西路支行");
        wait.until(elementToBeClickable(nextStepBtn)).click();
    }

    /**
     * 2、首次购买，需要签电子合同步骤
     * */

    public void signingElecContract(){
        logger.info("电子合同签名");
        wait.until(invisibilityOf(dialog));
        if (!hetongBox.isSelected()) {
            hetongBox.click();
        }
        TestUtils.sleep1s();
        nextStepBtn.click();
        wait.until(invisibilityOf(dialog));
        if (!allBox.isSelected()){
            allBox.click();
        }
        TestUtils.scrollEnd(driver);
        nextStepBtn.click();
    }


    /**
     * 3、确认购买
     * @param txPassword 交易密码，短信验证码默认111111
     * */

    public void confirmPurchase(String txPassword){
        wait.until(invisibilityOf(dialog));
        txPasswordText.sendKeys(txPassword);
        wait.until(elementToBeClickable(nextStepTwoBtn)).click();
        TestUtils.sleep3s();
        getVerifyCodeBtn.click();
        wait.until(visibilityOf(getVerifyCode));
        verifyCodeText.sendKeys("111111");
        wait.until(elementToBeClickable(checkVerifyCodeBtn)).click();
    }


    /**
     * 4、申请购买成功
     * */

    public Boolean isBuySuccess(){
        try {
            wait.until(invisibilityOf(dialog));
            wait.until(visibilityOf(buyingText));
        }catch (TimeoutException t){
            logger.error("产品购买失败.");
            return false;
        }
        return true;
    }


    public Boolean isSign(){
        return signingElecText.size() > 0;
    }

    /**
     * 买基金
     * */

    public void buyHighFund(String fundCode, String buyAmount, String txPassword){
        get();
        queryFund(fundCode);
        fillInOrder(buyAmount);
        if (isSign()){
            signingElecContract();
        }
        confirmPurchase(txPassword);
    }
}