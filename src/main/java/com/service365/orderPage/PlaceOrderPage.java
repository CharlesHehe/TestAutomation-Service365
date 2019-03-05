package com.service365.orderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"ContactNumber\"]")
    WebElement orderNumber;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[10]/div[1]/label/span[1]")
    WebElement privacyPolicies;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[10]/div[2]/button")
    WebElement submitButton;
    public PlaceOrderPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void setOrderNumber(String n){
        orderNumber.sendKeys(n);
    }
    public void clickPrivacyPolicies(){
        privacyPolicies.click();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
