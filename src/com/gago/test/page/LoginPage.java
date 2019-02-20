package com.gago.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gago.test.core.BasePage;

public class LoginPage extends BasePage {

    @FindBy(className = "username")
    WebElement username;

    @FindBy(className = "password")
    WebElement password;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[4]/div[1]/div[1]/div[7]/div[1]/a[1]")
    WebElement loginbtn;

    @FindBy(xpath = "//*[@id=\"mblog_photo\"]")
    WebElement userphoto;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserName() {
        input(username, "xujingbo1021@sina.com");
    }

    public void inputPassWord() {
        input(password, "xujingbo1995");
    }

    public void clickLoginBtn() {
        click(loginbtn);
    }

}
