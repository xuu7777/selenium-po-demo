package com.gago.test.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gago.test.core.BrowserEngine;
import com.gago.test.page.LoginPage;

public class TestUserLogin {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        BrowserEngine browserEngine = new BrowserEngine();
        browserEngine.initConfigData();
        driver = browserEngine.getBrowser();
        browserEngine.callWait(5);
    }

    @Test
    public void userLogin() {
        LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
        lp.inputUserName();
        lp.inputPassWord();
        lp.clickLoginBtn();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
