package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAddressPage {
    //    https://uat.service365.co.nz/Address/Edit
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"AddressLine1\"]")
    WebElement addressLine1;
    @FindBy(xpath = "//*[@id=\"AddressLine2\"]")
    WebElement addressLine2;
    @FindBy(xpath = "//*[@id=\"Suburb\"]")
    WebElement suburb;
    @FindBy(xpath = "//*[@id=\"City\"]")
    WebElement city;
    @FindBy(xpath = "//*[@id=\"PostCode\"]")
    WebElement postCode;
    @FindBy(xpath = "//*[@id=\"DangerOnSite\"]")
    WebElement note;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[7]/div/button")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[7]/div/a")
    WebElement cancelButton;
    public EditAddressPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void setAddressLine1(String a){
        addressLine1.sendKeys(a);
    }
    public void setAddressLine2(String a){
        addressLine2.sendKeys(a);
    }
    public void setSuburb(String s){
        suburb.sendKeys(s);
    }
    public void setCity(String c){
        city.sendKeys(c);
    }
    public void setPostCode(String p){
        postCode.sendKeys(p);
    }
    public void setNote(String n){
        note.sendKeys(n);
    }
    public void clickSaveButton(){
        saveButton.click();
    }
    public void clickCancelButton(){
        cancelButton.click();
    }


//    逻辑方法
    public void addNewAddress(String addressLine1,String addressLine2,String suburb,String city,String postCode,String note){

        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setSuburb(suburb);
        setCity(city);
        setPostCode(postCode);
        setNote(note);
        clickSaveButton();
    }
}
