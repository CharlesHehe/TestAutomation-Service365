package com.service365.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelectDriver {

    public WebDriver selectDriver(String driver){
        WebDriver webDriver=null;
        if(driver.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }else if(driver.equals("IE")){
            System.setProperty("webdriver.IE.driver", "browser/IEDriverServer.exe");
            webDriver = new InternetExplorerDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
}
