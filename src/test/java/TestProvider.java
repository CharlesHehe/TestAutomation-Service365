import com.service365.common.SelectDomain;
import com.service365.common.SelectDriver;
import com.service365.customerPage.HomePage;
import com.service365.customerPage.LoginPage;
import com.service365.providerPage.EditServicePage;
import com.service365.providerPage.ProviderMePage;
import com.service365.providerPage.RegisterPage;
import com.service365.providerPage.ServicePage;
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
    SelectDomain selectDomain;
    SelectDriver selectDriver;

    @BeforeTest(groups = "basic")
    @Parameters("environment")
    public void setup(String environment) {
        System.out.println(environment);
        selectDomain = new SelectDomain();
        properties = selectDomain.selectDomain(environment);
        selectDriver=new SelectDriver();
        webDriver=selectDriver.selectDriver("chrome");
    }

    @BeforeMethod()
    public void setHomePage() {
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
    public void testProviderLogin() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechen", "123456");
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("mePageURL"));
        Reporter.log("login success");
    }

    @Test(groups = "providerAddService")
    public void testProviderAddService() throws Exception {
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
        Assert.assertEquals(i, j - 1, "Successfully added service!");
        Reporter.log("商家添加服务case通过。");
    }

    @AfterTest()
    public void closeDriver() {
        webDriver.quit();
    }
}
