package com.service365.orderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/div[1]/div[2]/div/a")
    WebElement firstOrder;

    public MyOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickFirstOrder(){
        firstOrder.click();
    }
}
