package com.howbuy.simu;

import com.howbuy.common.PaymentType;
import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


/**
 * 高端产品购买页面
 * Created by yang.zhou on 2017/9/29.
 *
 * @author yang.zhou
 */
public class HighEndBuyPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(HighEndBuyPage.class.getName());

    private String buyListPath = "/newpcsm/buylist.html";

    /**
     * 基金代码查询
     */
    @FindBy(id = "searchFund_")
    private WebElement searchFundText;

    /**
     * 查询确定按钮
     */
    @FindBy(id = "searchFundBtn_")
    private WebElement searchFundBtn;

    /**
     * 模态框
     */
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    /**
     * 默认汇款方式
     */
    @FindBy(xpath = "//p[contains(text(),'默认回款方式')]")
    private WebElement defaultRemitText;

    /**
     * 选择储蓄罐
     */
    @FindBy(linkText = "回款至储蓄罐")
    private WebElement remitBoxText;


    /**
     * 选择回到银行卡
     */
    @FindBy(linkText = "回款至银行卡")
    private WebElement remitCardText;


    /**
     * 暂无数据元素
     */
    @FindBy(xpath = "//p[text()='暂无数据']")
    private WebElement noFund;

    /**
     * 购买按钮-可购买状态
     */
    @FindBy(css = "a[href^='buyindex.html?fundCode']")
    private WebElement buyIndexBtn;

    /**
     * 净购买金额
     */
    @FindBy(id = "buyAmount")
    private WebElement buyAmountText;

    /**
     * 选择储蓄罐
     */
    @FindBy(xpath = "//span[text()='储蓄罐']")
    private WebElement savingsBankLink;

    /**
     * 选择银行卡
     */
    @FindBy(xpath = "//span[text()='银行卡代扣']")
    private WebElement bankCardLink;

    /**
     * 选择线下转账
     */
    @FindBy(xpath = "//span[text()='银行转账划款']")
    private WebElement offlineTransferLink;


    /**
     * 选择第几张储蓄罐绑定的卡支付
     */
    @FindBy(css = "input[name=bank]")
    private List<WebElement> piggyBankCardinPut;

    /**
     * 选择银行卡
     */
    @FindBy(css = "input[name=bank2]")
    private List<WebElement> bankCardinPut;

    /**
     * 查询全部储蓄罐与银行卡绑定的卡
     */
    @FindAll({
            @FindBy(css = "input[name=bank2]"),
            @FindBy(css = "input[name=bank]")
    })
    private List<WebElement> bankCardList;


    /**
     * 支行名称
     */
    @FindBy(css = "input[data-bind*='bankSubName']")
    private List<WebElement> bankSubNameText;

    /**
     * 电子合同签名
     */
    @FindBy(xpath = "//p[text()='电子合同签订']")
    private List<WebElement> signingElecText;

    /**
     * 合同复选框
     */
    @FindBy(id = "hetong")
    private WebElement hetongBox;

    /**
     * 检查所有合同选项
     */
    @FindBy(id = "all")
    private WebElement allBox;

    /**
     * 检查是否存在勾选框
     */
    @FindBy(id = "all")
    private List<WebElement> checkBox;

    /**
     * 下一步按钮
     */
    @FindBy(linkText = "下一步")
    private WebElement nextStepBtn;

    /**
     * 交易密码
     */
    @FindBy(css = "input[data-bind*='txPassword']")
    private WebElement txPasswordText;

    /**
     * 购买确认信息按钮
     */
    @FindBy(linkText = "确认")
    private WebElement nextStepTwoBtn;

    /**
     * 手机号码
     */
    @FindBy(css = "input[data-bind*='mobile']")
    private WebElement mobileText;

    /**
     * 获取短信验证码
     */
    @FindBy(linkText = "获取短信验证码")
    private WebElement getVerifyCodeBtn;

    /**
     * 验证码倒计时
     */
    @FindBy(partialLinkText = "秒")
    private WebElement getVerifyCode;

    /**
     * 验证码
     */
    @FindBy(id = "verifyCode")
    private WebElement verifyCodeText;

    /**
     * 确认购买
     */
    @FindBy(linkText = "确认购买")
    private WebElement checkVerifyCodeBtn;

    /**
     * 购买成功
     */
    @FindBy(xpath = "//*[contains(text(),'购买申请')] | //span[text()='还需2步']")
    private WebElement buyingText;


    public HighEndBuyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Override
    public void open() {
        super.open(4085, buyListPath);
    }

    /**
     * 查询产品
     */

    public void queryFund(String fundCode) {
        open();
        try {
            wait.until(invisibilityOf(dialog));
            TestUtils.sleep2s();
            searchFundText.sendKeys(fundCode);
            wait.until(invisibilityOf(dialog));
            TestUtils.sleep1s();
            searchFundBtn.click();
            try {
                wait.until(invisibilityOf(dialog));
                TestUtils.sleep1s();
                buyIndexBtn.click();
            } catch (NoSuchElementException n) {
                TestUtils.screenshort(driver, fundCode + "产品无法购买.");
                throw new RuntimeException("产品" + fundCode + "无法购买.");
            }
        } catch (NoSuchElementException e) {
            TestUtils.screenshort(driver, fundCode + "查询失败.");
            throw new RuntimeException("查询产品失败：" + fundCode);
        }

    }


    /**
     * 购买按钮
     */

    public void clickBuyButton() {

        try {
            wait.until(invisibilityOf(dialog));
            TestUtils.sleep1s();
            buyIndexBtn.click();
        } catch (NoSuchElementException n) {
            throw new NoSuchElementException("该产品无法购买.");
        }
    }


    /**
     * 1、填写订单
     *
     * @param buyAmount   净购买金额
     * @param paymentType 1-储蓄罐，2-银行转账划款，3-银行代扣
     * @param index       选择第几张银行卡
     */

    public void fillInOrder(String buyAmount, PaymentType paymentType, int index) {
        wait.until(invisibilityOf(dialog));
        TestUtils.sleep2s();
        if (isRemitPopup()) {
            selectRemitText();
            TestUtils.sleep1s();
        }

        int count = 0;

        while (true) {
            try {
                buyAmountText.sendKeys(buyAmount);
                break;
            } catch (Exception e) {
                logger.error("输入申请金额失败，等待2s重试.", e);
                TestUtils.sleep2s();
                count++;
            }
            if (count > 3) {
                logger.error("输入申请金额失败,重试次数：" + count);
                throw new TimeoutException("输入申请金额异常.");
            }
        }

        logger.info("选择支付方式：" + paymentType.getName());

        if (paymentType == PaymentType.DEFAULT_PAY) {
            logger.info("选择默认支付方式.");
        } else {
            logger.info("非默认支付方式，选择其他支付方式：" + paymentType.getName());
            TestUtils.sleep1s();
        }

        if (paymentType == PaymentType.CXG_PAY) {
            savingsBankLink.click();
        }

        if (paymentType == PaymentType.BANK_LINE_PAY) {
            offlineTransferLink.click();
        }

        if (paymentType == PaymentType.BANK_CARD_PAY) {
            bankCardLink.click();
        }

        int size = bankCardList.size();
        if (size > 1 && size >= index) {
            WebElement bankCardChecked = bankCardList.get(index - 1);
            TestUtils.scrollTo(driver, bankCardChecked.getLocation().getY());
            if (!bankCardChecked.isSelected()) {
                logger.info("选择第" + index + "张银行卡支付.");
                bankCardChecked.click();
            }
        }

        TestUtils.scrollTo(driver, nextStepBtn.getLocation().getY());

        if (!bankSubNameText.isEmpty()) {
            bankSubNameText.get(0).sendKeys("上海南京西路支行web测试");
        }
        wait.until(elementToBeClickable(nextStepBtn)).click();
    }


    /**
     * 2、首次购买，需要签电子合同步骤,私募购买
     */

    public void signingElecContract() {
        logger.info("需要电子合同签名.");
        wait.until(invisibilityOf(dialog));
        if (!hetongBox.isSelected()) {
            hetongBox.click();
        }
        TestUtils.sleep1s();
        nextStepBtn.click();
        // 私募投资者声明处理，如果不存在私募声明，跳过执行
        wait.until(invisibilityOf(dialog));
        if (checkBox.size() > 0) {
            logger.info("私募投资者声明-条款处理");
            if (!allBox.isSelected()) {
                allBox.click();
            }
            TestUtils.scrollEnd(driver);
            nextStepBtn.click();
        }
    }


    /**
     * 3、确认购买
     *
     * @param txPassword 交易密码，短信验证码默认111111
     */

    public void confirmPurchase(String txPassword) {
        wait.until(invisibilityOf(dialog));
        txPasswordText.sendKeys(txPassword);
        wait.until(elementToBeClickable(nextStepTwoBtn)).click();
        TestUtils.sleep2s();
        getVerifyCodeBtn.click();
        wait.until(visibilityOf(getVerifyCode));
        verifyCodeText.sendKeys("111111");
        wait.until(elementToBeClickable(checkVerifyCodeBtn)).click();
    }


    /**
     * 4、申请购买成功
     */

    public void buyIsSuccess(String fundCode, String amount) {
        String result = "_失败了";
        try {
            wait.until(invisibilityOf(dialog));
            TestUtils.sleep2s();
            wait.until(visibilityOf(buyingText));
            logger.info("产品:" + fundCode + ".金额：" + amount + ". 购买成功!");
            result = "_成功";
        } catch (TimeoutException t) {
            logger.error("产品:" + fundCode + ", 金额：" + amount + ". 购买失败!");
        }
        TestUtils.screenshort(driver, "产品" + fundCode + "购买结果" + result);
    }

    /**
     * 选择银行卡
     *
     * @param elements 银行卡列表
     * @param index    选择第几张
     */
    private void chooseBankCard(List<WebElement> elements, int index) {
        int size = elements.size();
        if (size > 1 && size >= index) {
            WebElement bankCardChecked = elements.get(index - 1);
            TestUtils.scrollTo(driver, bankCardChecked.getLocation().getY());
            if (!bankCardChecked.isSelected()) {
                logger.info("选择第" + index + "张银行卡支付.");
                bankCardChecked.click();
            }
        }
    }


    /**
     * 是否存在回款弹出框
     */

    private Boolean isRemitPopup() {
        try {
            new WebDriverWait(driver, 2).until(visibilityOf(defaultRemitText));
            logger.info("需要选择回款协议");
            return true;
        } catch (TimeoutException t) {
            return false;
        }
    }


    /**
     * 选择回款协议
     */
    private void selectRemitText() {
        remitCardText.click();
    }


    /**
     * 购买买基金
     */

    public void buyHighFund(String fundCode, String buyAmount, PaymentType paymentType, int index, String txPassword) {
        queryFund(fundCode);
        fillInOrder(buyAmount, paymentType, index);
        if (!signingElecText.isEmpty()) {
            signingElecContract();
        }
        confirmPurchase(txPassword);
        buyIsSuccess(fundCode, buyAmount);
    }


    /**
     * 使用银行卡代扣
     */

    public void buyHighFund(String fundCode, String buyAmount, int index) {
        buyHighFund(fundCode, buyAmount, PaymentType.BANK_CARD_PAY, index, "121212");
    }


    /**
     * 使用银行卡代扣，需要传交易密码
     */

    public void buyHighFund(String fundCode, String buyAmount, String txPassword) {
        buyHighFund(fundCode, buyAmount, PaymentType.BANK_CARD_PAY, 1, txPassword);
    }


    /**
     * 使用银行卡代扣，默认选择第一张银行卡
     */

    public void buyHighFund(String fundCode, String buyAmount) {
        buyHighFund(fundCode, buyAmount, 1);
    }


    /**
     * 使用银行卡转账
     */

    public void buyBankLinePay(String fundCode, String buyAmount, int index) {
        buyHighFund(fundCode, buyAmount, PaymentType.BANK_LINE_PAY, index, "121212");
    }


    /**
     * 使用银行卡转账，默认选择选择第一张银行卡
     */

    public void buyBankLinePay(String fundCode, String buyAmount) {
        buyBankLinePay(fundCode, buyAmount, 1);
    }


    /**
     * 使用储蓄罐支付
     */

    public void buyPiggyPay(String fundCode, String buyAmount) {
        buyHighFund(fundCode, buyAmount, PaymentType.CXG_PAY, 1, "121212");
    }

}
