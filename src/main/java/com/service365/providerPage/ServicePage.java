package com.service365.providerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ServicePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[2]/td[2]/a")
    WebElement firstServiceTitle;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table")
    WebElement serviceList;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/h2/a")
    WebElement publishNewServceButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[2]/td[7]/a[1]")
    WebElement editService;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[2]/td[7]/a[2]")
    WebElement ableService;

    public ServicePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int getServiceNumber() {
        return serviceList.findElements(By.tagName("tr")).size() - 1;
    }

    public void clickPublishNewServiceButton() {
        publishNewServceButton.click();
    }

    public void clickEditService() {
        editService.click();
    }

    public void clickAbleService() {
        ableService.click();
    }

    public void checkServiceListNumber(int m, int n) {
        Assert.assertEquals(m, n - 1, "testProviderAddService case pass");
    }
    public void  checkFirstServiceTitle(String title){
        Assert.assertEquals(title,firstServiceTitle.getText());
    }

    public void changeServiceStatus() throws InterruptedException{
        int i = serviceList.findElements(By.tagName("tr")).size() - 1;
        int j = (int) (Math.random() * i + 2);
        WebElement status1 = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[" + j + "]/td[7]/a[2]"));
        String sta = status1.getText();
        if (sta.equals("DISABLE")) {
            status1.click();
            WebElement yesButton = webDriver.findElement(By.xpath("//*[@id=\"confirm\"]/div/div/div[3]/button[1]"));
            yesButton.click();
            Thread.sleep(3000);
            WebElement status2 = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[" + j + "]/td[7]/a[2]"));
            Assert.assertEquals(status2.getText(), "ENABLE");
        } else if (sta.equals("ENABLE")) {
            status1.click();
            WebElement yesButton = webDriver.findElement(By.xpath("//*[@id=\"confirm\"]/div/div/div[3]/button[1]"));
            yesButton.click();
            Thread.sleep(3000);
            WebElement status2 = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[" + j + "]/td[7]/a[2]"));
            Assert.assertEquals(status2.getText(), "DISABLE");
        }else{

        }
    }

}
