package com.gago.test.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gago.test.util.LogType;
import com.gago.test.util.Logger;

public class BrowserEngine {

    public String browserName;
    public String serverURL;
    public WebDriver driver;

    /**
     * 读取配置文件，获取浏览器类型和url地址
     */
    public void initConfigData() {
        try {
            Properties p = new Properties();
            InputStream ips = new FileInputStream(".\\testconfig\\config.properties");
            p.load(ips);
            Logger.Output(LogType.LogTypeName.INFO, "Start to select browser name from properties file");
            browserName = p.getProperty("browserName");
            Logger.Output(LogType.LogTypeName.INFO, "Your had select test browser type is: " + browserName);
            serverURL = p.getProperty("URL");
            Logger.Output(LogType.LogTypeName.INFO, "The test server URL is: " + serverURL);
            ips.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取webdriver驱动
     * 
     * @return
     */
    public WebDriver getBrowser() {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
            driver = new ChromeDriver();
            Logger.Output(LogType.LogTypeName.INFO, "Launching Chrome ...");
            driver.get(serverURL);
            Logger.Output(LogType.LogTypeName.INFO, "Open URL: " + serverURL);
            driver.manage().window().maximize();
            Logger.Output(LogType.LogTypeName.INFO, "Maximize browser...");
        }
        return driver;
    }

    /**
     * 关闭浏览器
     */
    public void tearDown() {
        try {
            Logger.Output(LogType.LogTypeName.INFO, "Closing browser...");
            driver.quit();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐式等待，如果超出了设置时间的则抛出异常。
     * 
     * @param time
     */
    public void callWait(int time) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Logger.Output(LogType.LogTypeName.INFO, "Wait for " + time + " seconds");
    }

}
