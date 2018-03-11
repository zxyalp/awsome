package com.howbuy.tms.simu;

import com.howbuy.simu.RegisterUserPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @author yang.zhou
 * @date 2018/1/9
 */
public class RegisterUserTest extends BaseTestCase {

    @Test
    public void registerUserTest01() throws Exception {
        RegisterUserPage userPage = PageFactory.initElements(driver, RegisterUserPage.class);
        userPage.createNewUser("35010119460101007X", "安七十一", "18217619891");
    }
}
