package com.service365.test;

import com.service365.common.PropertiesUtils;
import com.service365.customerPage.HomePage;
import com.service365.customerPage.LoginPage;
import com.service365.customerPage.MePage;
import com.service365.customerPage.MyAddressPage;
import com.service365.orderPage.MyOrderPage;
import com.service365.orderPage.OrderDetailPage;
import com.service365.orderPage.PlaceOrderPage;
import com.service365.orderPage.ServicePage;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class TestOrder {
    public Properties properties;
    WebDriver webDriver;
    HomePage homePage;
    MePage mePage;
    LoginPage loginPage;
    ServicePage servicePage;
    PlaceOrderPage placeOrderPage;
    OrderDetailPage orderDetailPage;
    MyOrderPage myOrderPage;

    @BeforeTest(groups = "basic")
    public void setup() {
        properties = PropertiesUtils.loadProp("config.properties");
        System.setProperty("webdriver.chrome.driver", "E:\\IDEA\\testing1\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://uat.service365.co.nz/");
        homePage = new HomePage(webDriver);
    }

    @Test(priority = 1, groups = "login")
    public void testLoginPage() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://uat.service365.co.nz/Profile/Me");
        mePage = new MePage(webDriver);

    }

    @Test(priority = 2, groups = "order")
    public void testOrderPage() {
        webDriver.get("https://uat.service365.co.nz/Services");
        servicePage = new ServicePage(webDriver);
        servicePage.setKeyWord("hire");
//        servicePage.setLocation("Auckland");
//        servicePage.setDistricts("df");
//        servicePage.setCategory("df");
        servicePage.clickSearch();
        Assert.assertNotEquals(webDriver.getCurrentUrl(), "https://uat.service365.co.nz/Services");
        List list = servicePage.getBookNowButtons();
        String url = (String) list.get((int) (Math.random() * list.size()));
        webDriver.get(url);
        placeOrderPage = new PlaceOrderPage(webDriver);
        placeOrderPage.setOrderNumber("123");
        placeOrderPage.clickPrivacyPolicies();
        placeOrderPage.clickSubmitButton();
        orderDetailPage = new OrderDetailPage(webDriver);
        System.out.println(orderDetailPage.orderNumber());
        Assert.assertEquals(orderDetailPage.orderWaiting(), "waiting service provider to confirm");
        System.out.println(orderDetailPage.topNote());
        Assert.assertEquals(orderDetailPage.orderStatus2(), "Service time confirmed by customer");
        Assert.assertEquals(orderDetailPage.orderStatus3(), "Provider to confirm service time");

        orderDetailPage.setMessageInput("sdfef");
        orderDetailPage.clickMessageSubmit();

    }

    @Test(priority = 2, groups = "cancelOrder")
    public void testCancelOrder()throws NoAlertPresentException,InterruptedException  {
        mePage.clickOrder();

        myOrderPage=new MyOrderPage(webDriver);
        myOrderPage.clickFirstOrder();
        orderDetailPage = new OrderDetailPage(webDriver);
        orderDetailPage.clickcCancelButton();
        orderDetailPage.acceptAlert();
        Assert.assertEquals(orderDetailPage.orderStatus4(),"Order cancelled");
        Assert.assertEquals(orderDetailPage.orderWaiting(),"cancelled");

    }
}
