import com.service365.common.PropertiesUtils;
import com.service365.customerPage.HomePage;
import com.service365.customerPage.LoginPage;
import com.service365.customerPage.MePage;
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
        webDriver.get(properties.getProperty("homePageURL"));
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
    public void testBookService() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        mePage=new MePage(webDriver);
        mePage.clickService();
        servicePage = new ServicePage(webDriver);
        servicePage.editFilterList("clean");
        List list = servicePage.getBookNowButtons();
        String url = (String) list.get((int) (Math.random() * list.size()));
        webDriver.get(url);
        placeOrderPage = new PlaceOrderPage(webDriver);
        placeOrderPage.setContactNumber("123");
        placeOrderPage.clickPrivacyPolicies();
        placeOrderPage.clickSubmitButton();
        orderDetailPage = new OrderDetailPage(webDriver);
        orderDetailPage.setMessageInput("sdfef");
        orderDetailPage.clickMessageSubmit();

    }
    @Test()
    public void testLeaveOrderMessage(){
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        mePage=new MePage(webDriver);
        mePage.clickOrder();
        myOrderPage = new MyOrderPage(webDriver);
        myOrderPage.clickRandomOrder();
        orderDetailPage=new OrderDetailPage(webDriver);
        orderDetailPage.setMessageInput("123");
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
