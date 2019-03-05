package com.service365.customerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;

public class MyAddressPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"verificationCode\"]")
    WebElement codeInput;
    @FindBy(xpath = "//*[@id=\"verifyCodeButton\"]")
    WebElement verifyButton;
    @FindBy(xpath = "//*[@id=\"confirm\"]/div/div/div[3]/button[1]")
    WebElement yesButton;
    @FindBy(xpath = "//*[@id=\"confirm\"]/div/div/div[3]/button[2]")
    WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/div")
    WebElement addressList;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/h2/a")
    WebElement addNewButton;
    public MyAddressPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public boolean verifyButtonCheck(){
        return verifyButton.isDisplayed();
    }
    public boolean yesButton(){
        return yesButton.isDisplayed();
    }
    public void setCodeInput(String c){
        codeInput.sendKeys(c);
    }
    public void clickVerifyButton(){
        verifyButton.click();
    }
    public void clickAddNewButton(){
        addNewButton.click();
    }
//    逻辑方法
    public void newAddressCheck(String addressLine1,String addressLine2,String suburb,String city,String postCode,String note){
        int sum =addressList.findElements(By.className("col-md-6")).size();
        WebElement newAddress=addressList.findElements(By.className("col-md-6")).get(sum-1);
        Assert.assertEquals(addressLine1,newAddress.findElements(By.tagName("dd")).get(0).getText());
        Assert.assertEquals(addressLine2,newAddress.findElements(By.tagName("dd")).get(1).getText());
        Assert.assertEquals(suburb,newAddress.findElements(By.tagName("dd")).get(2).getText());
        Assert.assertEquals(city,newAddress.findElements(By.tagName("dd")).get(3).getText());
        Assert.assertEquals(postCode,newAddress.findElements(By.tagName("dd")).get(4).getText());
        Assert.assertEquals(note,newAddress.findElements(By.tagName("dd")).get(5).getText());

    }
}
