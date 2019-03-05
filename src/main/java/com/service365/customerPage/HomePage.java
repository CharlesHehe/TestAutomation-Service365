package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"home\"]/div/div/div/div/a[2]")
    WebElement login;
    @FindBy(xpath = "//*[@id=\"home\"]/div/div/div/div/a[1]")
    WebElement register;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickLogin() {
        login.click();
    }

    public void clickRegister() {
        register.click();
    }
}
