package com.howbuy.smwap;

import com.howbuy.base.AbstractBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.Dimension;


/**
 * base page
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public abstract class BasePage extends AbstractBasePage {


    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public int timeOutInSeconds = 10;


    @Override
    public void get(String url) {
        get(url, new Dimension(620, 725));
    }

}
