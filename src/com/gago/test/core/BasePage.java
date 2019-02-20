package com.gago.test.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gago.test.util.LogType;
import com.gago.test.util.Logger;

public class BasePage {
    
    public static WebDriver driver;
    public static String pageTitle;
    public static String pageUrl;
    
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
    
    /**
     * 清除文本框内容
     * @param element
     */
    protected void clean(WebElement element) {
        try {
            if(element.isDisplayed()) {
                element.clear();
                Logger.Output(LogType.LogTypeName.INFO, "Element" + element.toString() + "was cleaned.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
        }
    }
    
    /**
     * 点击元素
     * @param element
     */
    protected void click(WebElement element) {
        try {
            if(element.isDisplayed()) {
                element.click();
                Logger.Output(LogType.LogTypeName.INFO, "Element" + element.toString() + "was clicked.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
        }
    }
    
    /**
     * 获取页面标题
     * @return
     */
    protected String getCurrentPageTitle() {
        pageTitle = driver.getTitle();
        Logger.Output(LogType.LogTypeName.INFO, "Current page title is "+pageTitle);
        return pageTitle;
    }
    
    /**
     * 获取页面的url
     * @return
     */
    protected String getCurrentPageUrl() {
        pageUrl = driver.getCurrentUrl();
        Logger.Output(LogType.LogTypeName.INFO, "Current page title is " + pageUrl);
        return pageUrl;
    }
    
    /**
     * 在文本框输入内容
     * @param element
     * @param text
     */
    protected void input(WebElement element, String text) {
        try {
            if(element.isDisplayed()) {
                element.clear();
                Logger.Output(LogType.LogTypeName.INFO, "Clean the value if any in "+ element.toString()+".");
                element.sendKeys(text);
                Logger.Output(LogType.LogTypeName.INFO, "Input value is: " + text+".");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
        }
    }
    
    /**
     * 判断一个元素是否在页面显示
     * @param string
     */
    protected void verifyElementIsPresent(WebElement element) {
        try {
            if(element.isDisplayed()) {
                Logger.Output(LogType.LogTypeName.INFO, "This Element " + element.toString().trim() + " is present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
        }
    }

}
