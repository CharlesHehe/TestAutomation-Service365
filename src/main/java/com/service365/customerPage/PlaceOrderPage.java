package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"ContactNumber\"]")
    WebElement contactNumber;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[9]/div[1]/label/span[1]/span")
    WebElement privacyPolicies;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[9]/div[2]/button")
    WebElement submitButton;
    public PlaceOrderPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void setContactNumber(String n){
        contactNumber.sendKeys(n);
    }
    public void clickPrivacyPolicies(){
        privacyPolicies.click();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
