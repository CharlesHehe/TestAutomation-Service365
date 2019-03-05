package com.service365.providerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"Username\"]")
    WebElement userName;
    @FindBy(xpath = "//*[@id=\"BusinessName\"]")
    WebElement tradeName;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div/div[2]/form/fieldset/div[3]/div")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    WebElement confirmPassword;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div/div[2]/form/fieldset/div[6]/div/div/label/span[1]")
    WebElement termButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div/div[2]/form/fieldset/div[7]/div[1]/button")
    WebElement registerButton;

    public RegisterPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void setUserName(String name){
        userName.sendKeys(name);
    }
    public void setTradeName(String name){
        tradeName.sendKeys(name);
    }
    public void setEmail(String e){
        email.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(e);
    }
    public void setPassword(String p){
        password.sendKeys(p);
    }
    public void setConfirmPassword(String c){
        confirmPassword.sendKeys(c);
    }
    public void clickTermButton(){
        termButton.click();
    }
    public void clickRegisterButton(){
        registerButton.click();
    }
}
