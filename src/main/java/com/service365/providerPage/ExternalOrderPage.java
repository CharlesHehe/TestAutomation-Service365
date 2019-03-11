package com.service365.providerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ExternalOrderPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[1]/div/div/h2/a")
    WebElement addNewExternalOrderButton;
    @FindBy(xpath = "//*[@id=\"listview\"]/table/tbody/tr[2]/td[7]/a[1]")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"listview\"]/table/tbody/tr[2]/td[7]/a[2]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"listview\"]/table/tbody")
    WebElement externalOrderList;

    public ExternalOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddNewExternalOrderButton() {
        addNewExternalOrderButton.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public int getExternalOrderListNumber() {
        return externalOrderList.findElements(By.tagName("tr")).size();
    }

    public void checkExternalOrderListNumber(int m, int n, String status) {
        if (status.equals("ADD")) {
            Assert.assertEquals(m, n - 1);
        } else if (status.equals("DELETE")) {
            Assert.assertEquals(m, n + 1);

        }


    }

//    public WebElement getRandomExternalOrder() {
//        List<WebElement> list = externalOrderList.findElements(By.tagName("tr"));
//        int i = externalOrderList.findElements(By.tagName("tr")).size();
//        return list.get((int)(Math.random()*i));
//    }

    public void deleteExternalOrder() throws InterruptedException {
        int i = externalOrderList.findElements(By.tagName("tr")).size();
        if (i >= 2) {
            WebElement deleteButton = webDriver.findElement(By.xpath("//*[@id=\"listview\"]/table/tbody/tr[" + (((int) (Math.random() * (i - 1))) + 2) + "]/td[7]/a[2]"));
            deleteButton.click();
            WebElement yesButton = webDriver.findElement(By.xpath("//*[@id=\"confirm\"]/div/div/div[3]/button[1]"));
            yesButton.click();
            Thread.sleep(3000);
        } else {
            System.out.println("You haven't created any external order yet. Please add one now if needed.");
            Reporter.log("You haven't created any external order yet. Please add one now if needed.");
        }

    }
}
