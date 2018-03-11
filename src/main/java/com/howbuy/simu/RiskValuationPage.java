package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * 风险测评页面
 *
 * @author yang.zhou
 * @date 2017/10/18
 */
public class RiskValuationPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(RiskValuationPage.class);

    /**
     * 查找所有单选框
     */
    @FindBy(css = "input[name=q1]")
    private List<WebElement> answerRadios;

    /**
     * 模态框
     */
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    /**
     * 风险测评页面选项
     */
    @FindBy(xpath = "//ul/ul")
    private List<WebElement> riskViews;

    /**
     * 风险测评提交按钮
     */
    @FindBy(linkText = "提交")
    private WebElement submitBtn;


    public RiskValuationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void riskAssess() {
        TestUtils.sleep2s();
        int[] result = new int[]{4, 4, 1, 4, 4, 4, 3, 1, 3, 4, 5, 4, 1, 3, 4, 4, 4, 2};
        int i = 0;
        for (WebElement element : riskViews) {
            logger.info("开始做高端风险问卷：" + i);
            TestUtils.sleep1s();
            WebElement checkedRadio = element.findElements(By.cssSelector("input[name=q1]")).get(result[i] - 1);
            checkedRadio.click();
            TestUtils.scrollTo(driver, checkedRadio.getLocation().getY());
            i++;
        }
        submitBtn.click();
    }

}
