package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import com.howbuy.tms.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * 订单审核页面
 *
 * @author yang.zhou
 * @date 2017/9/12
 */
public class OrderCheckPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(OrderCheckPage.class.getName());

    private String operatorNo;

    @FindBy(xpath = "//dt[contains(text(), '业务审核')]")
    @CacheLookup
    private WebElement businessMenu;

    @FindBy(xpath = "//dt[contains(text(), '交易审核(高端)')]")
    @CacheLookup
    private WebElement tradeCheckMenu;

    @FindBy(linkText = "柜台交易复核")
    @CacheLookup
    private WebElement counterCheckMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='countercheck.html']")
    @CacheLookup
    private WebElement checkFrame;

    @FindBy(id = "rsList")
    private WebElement resultsList;

    /**
     * 获取所有订单记录
     */
    @FindBy(xpath = "//tbody[@id='rsList']/tr[count(td)>8]")
    private List<WebElement> allOrderList;

    /**
     * 获取一条订单
     */
    @FindBy(xpath = "//tbody[@id='rsList']/tr[count(td)>8]")
    private WebElement firstOrder;

    /**
     * 获取首条复核按钮
     */
    @FindBys({@FindBy(xpath = "//tbody[@id='rsList']/tr[count(td)>8]"),
            @FindBy(className = "reCheck")})
    private WebElement firstCheckBtn;

    /**
     * 获取列表所有的订单明细记录
     */
    @FindBy(css = "#rsList td")
    private List<WebElement> orderDetailList;

    /**
     * 暂无审核记录元素
     */
    @FindBy(css = "#rsList td:only-child")
    private WebElement noCheckOrder;

    /**
     * 获取复核按钮
     */
    @FindBy(className = "reCheck")
    private List<WebElement> checkBtnList;

    /**
     * 获取订单中基金代码
     */
    @FindBy(xpath = "//*[@class='tabPop']//tr[1]/td[2]")
    private WebElement fundCodeText;

    @FindBy(xpath = "//*[@class='tabPop']//tr[2]/td[2]")
    private WebElement appAmtText;

    @FindBy(xpath = "//*[@class='tabPop']//tr[3]/td[2]")
    private WebElement bankAcctText;

    /**
     * 基金代码
     */
    @FindBy(css = "input[name=fundCode]")
    private WebElement fundCodeInput;

    /**
     * 申购赎回业务输入金额、份额
     */
    @FindBy(css = "input[name=appAmt]")
    private WebElement appAmtTextInput;

    /**
     * 输入银行卡尾号4号
     */
    @FindBy(css = "input[name=bankAcct]")
    private WebElement bankAcctInput;

    /**
     * 审核通过
     */
    @FindBy(className = "layui-layer-btn0")
    private WebElement approvedBtn;

    /**
     * 审核拒绝
     */
    @FindBy(className = "layui-layer-btn1")
    private WebElement refuseBtn;


    public OrderCheckPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void get(String url, String operatorNo) {
        this.operatorNo = operatorNo;
        driver.get(url + "?operatorNo=" + operatorNo);
        driver.manage().window().maximize();
        initPage();
    }

    public void initPage() {
        (wait.until(visibilityOf(businessMenu))).click();
        (wait.until(visibilityOf(tradeCheckMenu))).click();
        (wait.until(visibilityOf(counterCheckMenu))).click();
        checkFrame = wait.until(visibilityOf(checkFrame));
        driver.switchTo().frame(checkFrame);
    }


    public WebElement getFirstOrder() {
        if (orderDetailList.size() < 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException("无待审核记录.");
            }
        }
        return wait.until(visibilityOf(firstOrder));
    }

    public String getUrl(WebElement element) {
        return element.getAttribute("_href");
    }

    public String getUrl() {
        return getUrl(counterCheckMenu);
    }

    /**
     * 获取地址链接 operatorNo=
     */
    public String getOperatorNo() {
        return getUrl().split("operatorNo=")[1];
    }

    /**
     * 获取所有待审核订单列表数量
     */

    public int size() {
        TestUtils.sleep2s();
        logger.info("待审核订单条数：" + allOrderList.size());
        return allOrderList.size();
    }

    /**
     * 获取首条订单子信息
     */

    public List<WebElement> getOrderDetail() {
        return getFirstOrder().findElements(By.cssSelector("td"));
    }

    /**
     * 获取订单操作员
     */

    public String getOperator() {
        return getOrderDetail().get(7).getText();
    }

    /**
     * 判断订单审核的操作员是否订单创建人员是否是同一个人
     */

    public boolean isSameOperator() {
        if (getOperator().equals(this.operatorNo)) {
            logger.info("订单审核操作员与创建人员是同一个人");
            driver.switchTo().defaultContent();
            return true;
        }
        return false;
    }

    /**
     * 如果返回另一个用户
     */

    public String getOtherOperator() {
        if (this.operatorNo.equals("s001")) {
            return "s002";
        }
        return "s001";
    }

    /**
     * 复核第一条订单
     */

    public void checkFirstOrder() {
        TestUtils.sleep3s();
        WebElement reviewCheckBtn = getFirstOrder().findElement(By.cssSelector(".reCheck"));
        logger.info("点击复核操作按钮");
        reviewCheckBtn.click();
    }

    /**
     * 获取复核信息中基金代码(fundCode)、金额/份额(appAmt)、银行卡尾号4位(bankAcct);
     */

    public Map<String, String> getReviewInfo() {
        appAmtText = wait.until(visibilityOf(appAmtText));
        String appAmt = TestUtils.matcher(appAmtText.getText(), "\\.|\\d");
        String bankAcct = TestUtils.matcher(bankAcctText.getText(), "\\d");
        logger.info("提取金额、银行卡号后4位：" + appAmt + "," + bankAcct);
        Map<String, String> fund = new HashMap<>();
        fund.put("fundCode", fundCodeText.getText());
        fund.put("appAmt", appAmt);
        fund.put("bankAcct", bankAcct);
        logger.info("获取复核信息中基金代码、金额/份额、银行卡尾号4位：" + fund.toString());
        return fund;
    }

    public void checkOrder() {

        Map<String, String> checkResult = getReviewInfo();
        TestUtils.sleep1s();
        fundCodeInput.sendKeys(checkResult.get("fundCode"));
        TestUtils.sleep1s();
        appAmtTextInput.sendKeys(checkResult.get("appAmt"));
        TestUtils.sleep1s();
        bankAcctInput.sendKeys(checkResult.get("bankAcct"));
        TestUtils.sleep1s();
    }

    public void approvedByOrder() {
        checkOrder();
        approvedBtn.click();
    }

    public void refuseByOrder() {
        checkOrder();
        refuseBtn.click();
    }

}
