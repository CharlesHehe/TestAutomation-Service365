package com.service365.providerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table")
    WebElement serviceList;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/h2/a")
    WebElement publishNewServceButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[2]/td[7]/a[1]")
    WebElement editService;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/table/tbody/tr[2]/td[7]/a[2]")
    WebElement ableService;

    public ServicePage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public int getServiceNumber(){
        return serviceList.findElements(By.tagName("tr")).size()-1;
    }
    public void clickPublishNewServiceButton(){
        publishNewServceButton.click();
    }
    public void clickEditService(){
        editService.click();
    }
    public void clickAbleService(){
        ableService.click();
    }


}
