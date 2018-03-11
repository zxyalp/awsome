package com.howbuy.smwap;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 搜索产品
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public class SearchFundPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(SearchFundPage.class.getName());


    public String buyListPath = "/smtradewap/buylist.html";

    /**
     * 加载框
     */
    @FindBy(css = "#loading:empty")
    private WebElement loading;

    /**
     * wap主页买基金链接
     */
    @FindBy(linkText = "买私募")
    private WebElement buyListLink;

    /**
     * 基金搜索框
     */
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    /**
     * 基金搜索按钮
     */
    @FindBy(css = "input[value='搜索']")
    private WebElement searchBtn;

    @FindBy(className = "buy_list")
    private List<WebElement> buyList;

    /**
     * 结果列表-购买按钮
     */
    @FindBy(css = "input[value='购买']")
    private WebElement buyBtn;

    /**
     * 结果列表-已售罄按钮
     */
    @FindBy(css = "input[value='已售罄']")
    private List<WebElement> floridianBtn;


    public SearchFundPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void searchFund(String fundCode) {
        open();
        try {
            wait.until(visibilityOf(searchInput)).sendKeys(fundCode);
            searchBtn.click();
            TestUtils.sleep2s();
            if (buyList.isEmpty()) {
                throw new RuntimeException("没有查到结果");
            }

            if (!buyBtn.isEnabled()) {
                throw new RuntimeException("购买按钮不可用");
            }
            if (floridianBtn.size() > 0) {
                throw new RuntimeException("产品已售罄.");
            }
            buyBtn.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("查询产品超时》", e);
        }

    }

    @Override
    public void open() {
        super.open(15080, buyListPath);
    }
}
