package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 储蓄罐存入
 *
 * @author yang.zhou
 * @date 2017/11/9
 */
public class PiggyBankPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(PiggyBankPage.class.getName());

    private String piggyPath = "/newpc/pcfund/module/pcfund/view/piggyIndex.html";

    /**
     * 模态框
     */
    @FindBy(className = "dialog2")
    private WebElement dialog;

    /**
     * 存活期按钮
     */
    @FindBy(linkText = "存活期")
    private WebElement depositBtn;

    /**
     * 取活期
     */
    @FindBy(linkText = "取活期")
    private WebElement withDrawBtn;

    /**
     * 存入金额
     */
    @FindBy(css = "input[data-bind*='amount']")
    private WebElement amountText;

    /**
     * 下一步
     */
    @FindBy(linkText = "下一步")
    private WebElement nextStep;

    /**
     * 交易密码
     */
    @FindBy(css = "input[data-bind*='tradePassword']")
    private WebElement tradePasswordText;

    /**
     * 确认存入
     */
    @FindBy(linkText = "确认存入")
    private WebElement confirmBtn;

    /**
     * 恭喜！您的存入已成功！
     */
    @FindBy(xpath = "//p[contains(text(),'您的存入已成功')]")
    private WebElement depositSuccess;


    public PiggyBankPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Override
    public void open() {
        super.open(4085, piggyPath);
    }

    public void depositInform(String amount) {
        wait.until(visibilityOf(depositBtn)).click();
        TestUtils.sleep1s();
        wait.until(visibilityOf(amountText)).sendKeys(amount);
        TestUtils.scrollTo(driver, nextStep.getLocation().getY());
        nextStep.click();
    }

    public void confirmDepositInfo() {
        wait.until(invisibilityOf(dialog));
        tradePasswordText.sendKeys("121212");
        confirmBtn.click();
        wait.until(invisibilityOf(dialog));
    }

    public void savingBox(String amount) {
        open();
        depositInform(amount);
        confirmDepositInfo();
        try {
            wait.until(invisibilityOf(dialog));
            wait.until(visibilityOf(depositSuccess));
        } catch (TimeoutException t) {
            logger.error("储蓄罐存入活期失败.", t);
        }
        logger.info("存入活期成功");
    }

}
