package com.service365.test;


import com.service365.common.PropertiesUtils;
import com.service365.customerPage.HomePage;
import com.service365.customerPage.LoginPage;
import com.service365.providerPage.RegisterPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestProvider {
    public Properties properties;
    WebDriver webDriver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeTest(groups = "basic")
    public void setup() {
        properties = PropertiesUtils.loadProp("config.properties");
        System.setProperty("webdriver.chrome.driver", "E:\\IDEA\\testing1\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(properties.getProperty("homePageURL"));
        homePage = new HomePage(webDriver);
    }

//    @Test(groups = "providerRegister")
//    public void testProviderRegister() {
//        homePage.clickRegister();
//        registerPage = new RegisterPage(webDriver);
//        registerPage.setUserName("Charles");
//        registerPage.setTradeName("Charles");
//        registerPage.setEmail("hechenjuner@gmail.com");
//        registerPage.setPassword("123456");
//        registerPage.setConfirmPassword("123456");
//        registerPage.clickTermButton();
//        registerPage.clickRegisterButton();
//    }

    @Test(groups = "providerLogin")
    public void testProviderLogin(){
        homePage.clickLogin();
        loginPage=new LoginPage(webDriver);
        loginPage.setUsername("hechen");
        loginPage.setPassword("123456");
        loginPage.clickLogin();
        Assert.assertEquals(webDriver.getCurrentUrl(),properties.getProperty("mePageURL"));
        Reporter.log("login success");
    }
    @Test(groups = "providerEditProfile")
    public void testProviderEditProfile(){

    }
}
