import com.service365.common.SelectDomain;
import com.service365.common.SelectDriver;
import com.service365.customerPage.HomePage;
import com.service365.customerPage.LoginPage;
import com.service365.providerPage.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.Properties;

public class TestProvider {
    public Properties properties;
    WebDriver webDriver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    ProviderMePage providerMePage;
    ServicePage servicePage;
    EditServicePage editServicePage;
    ExternalOrderPage externalOrderPage;
    EditExternalOrderPage editExternalOrderPage;
    SelectDomain selectDomain;
    SelectDriver selectDriver;

    @BeforeTest(groups = "basic")
    @Parameters("environment")
    public void setup(String environment) {
        System.out.println(environment);
        selectDomain = new SelectDomain();
        properties = selectDomain.selectDomain(environment);
    }

    @BeforeMethod()
    public void setHomePage() {
        selectDriver = new SelectDriver();
        webDriver = selectDriver.selectDriver("chrome");
        webDriver.get(properties.getProperty("homePageURL"));
        homePage = new HomePage(webDriver);
    }

    @AfterMethod()
    public void closeDriver() {
        webDriver.close();
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
    public void testProviderLogin() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("mePageURL"));
        Reporter.log("provider login pass");
    }

    @Test(groups = "providerAddService")
    public void testAddService() throws Exception {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        providerMePage = new ProviderMePage(webDriver);
        providerMePage.clickService();
        servicePage = new ServicePage(webDriver);
//        添加之前service的数量
        int i = servicePage.getServiceNumber();
        servicePage.clickPublishNewServiceButton();
        editServicePage = new EditServicePage(webDriver);
        editServicePage.editService("1", "up to", "3", "@!!", "dsfe", "dfbbgbttttttttttttttttttttt", "D:\\anotherPig.jpg");
        webDriver.get(properties.getProperty("myServiceURL"));
//        添加之后service的数量
        int j = servicePage.getServiceNumber();
        servicePage.checkServiceListNumber(i, j);
        System.out.println("testProviderAddService case pass");
        Reporter.log("testProviderAddService case pass");
    }

    @Test()
    public void testAddExternalOrder() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        providerMePage = new ProviderMePage(webDriver);
        providerMePage.clickExternalOrder();
        externalOrderPage = new ExternalOrderPage(webDriver);
        int m = externalOrderPage.getExternalOrderListNumber();
        externalOrderPage.clickAddNewExternalOrderButton();
        editExternalOrderPage = new EditExternalOrderPage(webDriver);
        editExternalOrderPage.setAllElementExternalOrder("ExternalOrder", "ExternalOrder", "ExternalOrder"
                , "ExternalOrder", "ExternalOrder@gmail.com", "ExternalOrder", "ExternalOrder", "123", "ExternalOrder");
        int n = externalOrderPage.getExternalOrderListNumber();
        externalOrderPage.checkExternalOrderListNumber(m, n);
        System.out.println("testProviderAddExternalOrder case pass");
        Reporter.log("testProviderAddExternalOrder case pass");
    }

    @Test()
    public void testDeleteExternalOrder() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        providerMePage = new ProviderMePage(webDriver);
        providerMePage.clickExternalOrder();
        externalOrderPage = new ExternalOrderPage(webDriver);
        int i = externalOrderPage.getExternalOrderListNumber();
        externalOrderPage.deleteExternalOrder();
        int j = externalOrderPage.getExternalOrderListNumber();
        externalOrderPage.checkExternalOrderListNumber(i, j);
        System.out.println("testDeleteExternalOrder case pass");
        Reporter.log("testDeleteExternalOrder case pass");
    }

    @Test()
    public void testEnableService() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        providerMePage = new ProviderMePage(webDriver);
        providerMePage.clickService();
        servicePage = new ServicePage(webDriver);
        servicePage.changeServiceStatus();
        System.out.println("testEnableService case pass");
        Reporter.log("testEnableService case pass");
    }

    @AfterTest()
    public void quit() {
        webDriver.quit();
    }
}
