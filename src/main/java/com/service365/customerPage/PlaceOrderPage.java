package com.service365.customerPage;

import com.service365.common.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;
import java.util.Date;
import java.util.Properties;

public class PlaceOrderPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"ContactNumber\"]")
    WebElement contactNumber;
    @FindBy(xpath = "//*[@id=\"ServiceTime\"]")
    WebElement preferredTime;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[9]/div[1]/label/span[1]/span")
    WebElement privacyPolicies;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[9]/div[2]/button")
    WebElement submitButton;
    public Properties common;

    public PlaceOrderPage(WebDriver webDriver) {
        common = PropertiesUtils.loadProp("common.properties");
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void setContactNumber(String n) {
        contactNumber.sendKeys(n);
    }

    public void clickPrivacyPolicies() {
        privacyPolicies.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void setPreferredTime(String time) {
        preferredTime.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.getElementById('ServiceTime').readOnly=false;");
        preferredTime.clear();
        webDriver.findElement(By.id("ServiceTime")).sendKeys(time);
        preferredTime.click();
    }

    //    Logical method
    public void setAllElement() {
        setContactNumber("123");
        clickPrivacyPolicies();
        clickSubmitButton();
    }

    //    Check if the reservation can be successful
    public void checkPlaceOrderUrl() {
        setPreferredTime(common.getProperty("setPreferredTime"));
        clickPrivacyPolicies();
        clickSubmitButton();
    }
}
