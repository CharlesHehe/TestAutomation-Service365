import com.service365.common.PropertiesUtils;
import com.service365.customerPage.*;
import com.service365.customerPage.MyOrderPage;
import com.service365.customerPage.OrderDetailPage;
import com.service365.customerPage.PlaceOrderPage;
import com.service365.customerPage.ServicePage;
import com.service365.readData.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.*;


public class TestCustomer {
    public Properties properties;
    WebDriver webDriver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MePage mePage;
    EditProfilePage editProfilePage;
    ChangePasswordPage changePasswordPage;
    EditAddressPage editAddressPage;
    MyAddressPage myAddressPage;
    MyOrderPage myOrderPage;
    OrderDetailPage orderDetailPage;
    PlaceOrderPage placeOrderPage;
    ServicePage servicePage;

    @BeforeTest(groups = "basic")
    @Parameters({"environment"})
    public void setup() {
        String en=System.getProperty("environment");
        if(en.equals("dev")){
            properties = PropertiesUtils.loadProp("dev.properties");
            System.out.println("dev");
        }else if(en.equals("uat")){
            properties = PropertiesUtils.loadProp("uat.properties");
            System.out.println("uat");
        }else {
            properties = PropertiesUtils.loadProp("dev.properties");
        }

        System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        mePage = new MePage(webDriver);
        webDriver.get(properties.getProperty("homePageURL"));
        homePage = new HomePage(webDriver);
    }


    @Test(priority = 1, groups = "register")
    public void testCustomerRegister() throws InterruptedException {
        homePage.clickRegister();
        registerPage = new RegisterPage(webDriver);
        registerPage.registerService365("3109272895@qq.com","123456","123456",true,true);
        Thread.sleep(5000);
//        测试是否进入home页面
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("mePageURL"));
        mePage.myPageStatus();
        Reporter.log("用户注册case通过。");
    }

    @Test(priority = 1, groups = "login")
    public void testLoginPage() throws InterruptedException {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        Thread.sleep(5000);
//        测试是否进入mePage页面
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("mePageURL"));
    }


    @Test(priority = 2, groups = "changePicture")
    public void testChangeProfilePicture() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        String currentPicture = mePage.imageCheck();
        mePage.changePicture();
        String laterPicture = mePage.imageCheck();
        Assert.assertNotEquals(laterPicture, currentPicture);
    }

    @Test(priority = 3, groups = "editProfile")
    public void testEditProfile() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        editProfilePage = new EditProfilePage(webDriver);
        mePage.clickEditProfile();
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("editProfileURL"));
        editProfilePage.editProfile("chenjuner","9999999","Male","I am pretty!");
        Assert.assertEquals(mePage.nickNameCheck(),"chenjuner");
        Assert.assertEquals(mePage.contactNumberCheck(),"9999999");
        Assert.assertEquals(mePage.instructionCheck(),"I am pretty!");
        Reporter.log("用户修改个人信息case通过。");
    }

    @Test(priority = 4, groups = "changePassword", dataProvider = "dataProvider")
    public void testChangePassword(HashMap<String, String> data) {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        changePasswordPage = new ChangePasswordPage(webDriver);
        mePage.clickChangePassword();
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("changePasswordURL"));
        changePasswordPage.changePassword(data.get("Current password"),data.get("New password"),data.get("Confirm password"));
//        changePasswordPage.changePassword("123456q","123456","123456");
        webDriver.get(properties.getProperty("loginPageURL"));
        loginPage.loginToService365("hechenjuner@gmail.com",data.get("New password"));
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("mePageURL"));
        Reporter.log("用户修改密码case通过。");
    }

    @Test(priority = 5, groups = "addAddress")
    public void testAddAddress() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        mePage.clickAddress();
        myAddressPage=new MyAddressPage(webDriver);
        myAddressPage.clickAddNewButton();
        editAddressPage = new EditAddressPage(webDriver);
        editAddressPage.addNewAddress("1q","1w","1e","1r","1t","1y");
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("myAddressURL"));
        myAddressPage.newAddressCheck("1q","1w","1e","1r","1t","1y");
        Reporter.log("用户添加地址case通过。");
    }


    @DataProvider(name = "dataProvider")
    public Object[][] getDataFromDataprovider() {
        ReadExcelFile readExcelFile = new ReadExcelFile();
        String filePath = "data";
        Object[][] o = null;
        try {
            o = readExcelFile.readExcel(filePath, "asdf.xlsx", "asdf");
        } catch (IOException e) {

        }
        return o;

    }

    @Test(priority = 7, groups = "findPassword")
    public void testFindPassword() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.clickRecoverPassword();
        List listA;

        listA = webDriver.findElements(By.tagName("a"));
        Reporter.log("There are " + listA.size() + " links in this page!");
        Iterator iteratorA = listA.iterator();
        while (iteratorA.hasNext()) {
            WebElement tagA = (WebElement) iteratorA.next();
            String url = tagA.getAttribute("href");
            if (url == null || url.equals(null) || url.equals("")) {
                Reporter.log("current url is \"\"");
            } else {
                Reporter.log("current url " + url);
            }


        }

    }
    @Test(priority = 2, groups = "order")
    public void testBookService() {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        mePage=new MePage(webDriver);
        mePage.clickService();
        servicePage = new ServicePage(webDriver);
        servicePage.editFilterList("work");
        List list = servicePage.getBookNowButtons();
        String url = (String) list.get((int) (Math.random() * list.size()));
        webDriver.get(url);
        placeOrderPage = new PlaceOrderPage(webDriver);
        placeOrderPage.setContactNumber("123");
        placeOrderPage.clickPrivacyPolicies();
        placeOrderPage.clickSubmitButton();
        orderDetailPage = new OrderDetailPage(webDriver);
//        检查各项信息是否正确
        orderDetailPage.orderStatus();
        Reporter.log("用户预订服务case通过。");
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
//        order顺序应该是倒序，case未完
    }
    @Test(priority = 2, groups = "cancelOrder")
    public void testCancelOrder()throws NoAlertPresentException,InterruptedException  {
        homePage.clickLogin();
        loginPage = new LoginPage(webDriver);
        loginPage.loginToService365("hechenjuner@gmail.com","123456");
        mePage=new MePage(webDriver);
        mePage.clickOrder();
        myOrderPage=new MyOrderPage(webDriver);
        myOrderPage.clickRandomOrder();
        orderDetailPage = new OrderDetailPage(webDriver);
        orderDetailPage.clickcCancelButton();
        orderDetailPage.acceptAlert();
        Assert.assertEquals(orderDetailPage.orderStatus4(),"Order cancelled");
        Assert.assertEquals(orderDetailPage.orderWaiting(),"cancelled");
        Reporter.log("用户取消订单case通过。");

    }
    @AfterTest()
    public void quit() {
        webDriver.quit();
    }
}
