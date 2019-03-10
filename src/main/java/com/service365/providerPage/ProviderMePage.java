package com.service365.providerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProviderMePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[2]/a")
    WebElement service;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[6]/a")
    WebElement externalOrder;
    public ProviderMePage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void clickService(){
        service.click();
    }
    public void clickExternalOrder(){
        externalOrder.click();
    }
}
