package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"UserName\"]")
    WebElement username;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement password;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/form[1]/fieldset/div[3]/div[1]/button")
    WebElement loginButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/a[2]")
    WebElement recoverPassword;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickRecoverPassword(){
        recoverPassword.click();
    }
    public void setUsername(String name){
        username.sendKeys(name);
    }
    public void setPassword(String password1){
        password.sendKeys(password1);
    }
    public void clickLogin(){
        loginButton.click();
    }

//    逻辑方法
    public void loginToService365(String name,String password){
        this.setUsername(name);
        this.setPassword(password);
        this.clickLogin();
    }
}
