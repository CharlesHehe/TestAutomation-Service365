package com.service365.providerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditExternalOrderPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"Title\"]")
    WebElement title;
    @FindBy(xpath = "//*[@id=\"LongAddress\"]")
    WebElement serviceAddress;
    @FindBy(xpath = "//*[@id=\"CustomerName\"]")
    WebElement customerName;
    @FindBy(xpath = "//*[@id=\"ContactNumber\"]")
    WebElement contactNumber;
    @FindBy(xpath = "//*[@id=\"EmailAddress\"]")
    WebElement customerEmail;
    @FindBy(xpath = "//*[@id=\"ServiceTimeStart\"]")
    WebElement serviceTimeStart;
    @FindBy(xpath = "//*[@id=\"ServiceTimeEnd\"]")
    WebElement serviceTimeEnd;
    @FindBy(xpath = "//*[@id=\"Price\"]")
    WebElement price;
    @FindBy(xpath = "//*[@id=\"Notes\"]")
    WebElement notes;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[2]/form/fieldset/div[10]/div/button")
    WebElement saveButton;

    public EditExternalOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void setTitle(String t) {
        title.sendKeys(t);
    }

    public void setServiceAddress(String s) {
        serviceAddress.sendKeys(s);
    }

    public void setCustomerName(String c) {
        customerName.sendKeys(c);
    }

    public void setContactNumber(String cNumber) {
        contactNumber.sendKeys(cNumber);
    }

    public void setCustomerEmail(String cEmail) {
        customerEmail.sendKeys(cEmail);
    }

    public void setServiceTimeStart(String sTimeStart) {
        serviceTimeStart.sendKeys();
        serviceTimeStart.sendKeys(sTimeStart);
    }

    public void setServiceTimeEnd(String sTimeEnd) {
        serviceTimeEnd.sendKeys();
        serviceTimeEnd.sendKeys(sTimeEnd);
    }

    public void setPrice(String p) {
        price.sendKeys(p);
    }

    public void setNotes(String n) {
        notes.sendKeys(n);
    }

    public void clickSave() {
        saveButton.click();
    }

//    logic method

    public void setAllElementExternalOrder(String title, String serciveAddress, String customerName, String contactNumber,
                                           String contactEmail, String serviceTimeStart, String serviceTimeEnd, String price, String notes) {
        setTitle(title);
        setServiceAddress(serciveAddress);
        setCustomerName(customerName);
        setContactNumber(contactNumber);
        setCustomerEmail(contactEmail);
//        setServiceTimeStart(serviceTimeStart);
//        setServiceTimeEnd(serviceTimeEnd);
        setPrice(price);
        setNotes(notes);
        clickSave();
    }

}
