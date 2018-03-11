package com.howbuy.smwap;

import com.howbuy.common.PaymentType;
import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 支付购买页面
 *
 * @author yang.zhou
 * @date 2017/12/21
 */
public class PayInfoPage extends BasePage {


    private final Logger logger = LoggerFactory.getLogger(PayInfoPage.class.getName());


    /**
     * 加载框
     */
    @FindBy(css = "#loading:empty")
    private WebElement loading;

    @FindBy(id = "cxgPayTip")
    private WebElement cxgPayTip;

    @FindBy(css = "input[value='我知道了']")
    private WebElement msgBtn;

    /**
     * 买入金额
     */
    @FindBy(id = "buyAmount")
    private WebElement buyAmount;

    /**
     * 支付金额
     */
    @FindBy(id = "payAmount")
    private WebElement payAmount;

    /**
     * 手续费
     */
    @FindBy(id = "feeAmount")
    private WebElement feeAmount;

    @FindBy(id = "cxgBankListDiv")
    private WebElement cxgBankList;

    /**
     * 更换支付方式
     */
    @FindBy(xpath = "//span[text()='更换支付方式']")
    private WebElement payMethods;

    /**
     * 储蓄罐支付
     */
    @FindBy(id = "pay_byCxg")
    private WebElement payXcg;

    /**
     * 银行卡转账
     */
    @FindBy(id = "pay_byBank_xx")
    private WebElement payBankLine;

    /**
     * 银行卡代扣
     */
    @FindBy(id = "pay_byBank")
    private WebElement payBank;

    /**
     * 银行支行名称
     */
    @FindBy(id = "branchName")
    private List<WebElement> branchName;

    /**
     * 银行卡列表
     */
    @FindBy(css = "span[id^='card']")
    private List<WebElement> bankCardList;

    /**
     * 选择银行卡与储蓄罐
     */
    @FindAll({
            @FindBy(css = "span[id^='card']"),
            @FindBy(css = "#cxgBankListDiv span[data-tabindex]")
    })
    private List<WebElement> cxgAndBankList;

    /**
     * 下一步
     */
    @FindBy(css = "[value='下一步']")
    private WebElement nextStepBtn;

    /**
     * 二次风险确认
     */
    @FindBy(css = "[value='继续购买']")
    private List<WebElement> twoRiskBtn;

    public PayInfoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    /**
     * 购买第一步
     *
     * @param amount      买入金额
     * @param paymentType 支付方式：0-储蓄罐，1-银行转账，2-银行代扣
     * @param index
     */
    public void pay(String amount, int index, PaymentType paymentType) {
        try {
            TestUtils.sleep1s();

            if (cxgPayTip.isDisplayed()) {
                logger.info("关闭储蓄罐支付上线提示tip.");
                msgBtn.click();
            }

            wait.until(visibilityOf(buyAmount)).sendKeys(amount);
            TestUtils.sleep1s();

            logger.info("选择支付方式：" + paymentType.getName());

            if (paymentType == PaymentType.DEFAULT_PAY) {
                logger.info("选择默认支付方式.");
            } else {
                logger.info("非默认支付方式，选择其他支付方式：" + paymentType.getName());
                payMethods.click();
                TestUtils.sleep1s();
            }

            if (paymentType == PaymentType.CXG_PAY) {
                payXcg.click();
            }

            if (paymentType == PaymentType.BANK_LINE_PAY) {
                payBankLine.click();
            }

            if (paymentType == PaymentType.BANK_CARD_PAY) {
                payBank.click();
            }

            TestUtils.sleep1s();

            int size = cxgAndBankList.size();
            if (size > 1 && size >= index) {
                WebElement bankCardChecked = cxgAndBankList.get(index - 1);
                TestUtils.scrollTo(driver, bankCardChecked.getLocation().getY());
                if (!bankCardChecked.isSelected()) {
                    logger.info("选择第" + index + "张银行卡支付.");
                    bankCardChecked.click();
                }
            }

            if (!branchName.isEmpty()) {
                branchName.get(0).sendKeys("wap测试支行");
            }

            TestUtils.scrollTo(driver, nextStepBtn.getLocation().getY());

            if (nextStepBtn.isEnabled()) {
                nextStepBtn.click();
            } else {
                logger.error("下一步按钮不可用");
                throw new RuntimeException("下一步按钮不可用");
            }

            TestUtils.sleep1s();

            if (!twoRiskBtn.isEmpty()) {
                logger.info("需要客户二次风险确认.");
                twoRiskBtn.get(0).click();
            }

        } catch (TimeoutException e) {
            throw new TimeoutException("下单异常");
        }
    }


}
