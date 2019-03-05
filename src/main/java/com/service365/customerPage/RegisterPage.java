package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"Email\"]")
    WebElement registerEmail;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement registerPassword;
    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    WebElement registerConfirmPassword;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div/div[2]/form[1]/fieldset/div[4]/div/div/label/span[1]/span")
    WebElement termAgreeButton;
    @FindBy(xpath ="/html/body/div[1]/div/div/div[1]/div[1]/div/div[2]/form[1]/fieldset/div[4]/div/div/label/span[2]/a" )
    WebElement termUrl1;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div/div[2]/form/fieldset/div[6]/div/div/label/span[2]/a")
    WebElement termUrl2;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div/div[2]/form[1]/fieldset/div[5]/div[1]/button")
    WebElement registerButton;

    public RegisterPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void setRegisterEmail(String email){
        registerEmail.sendKeys(email);
    }
    public void setRegisterPassword(String password){
        registerPassword.sendKeys(password);
    }
    public void setRegisterConfirmPassword(String confirmPassword){
        registerConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickAgreeButton(){
        termAgreeButton.click();
    }
    public void clickRegister(){
        registerButton.click();
    }
    public boolean clickTermUrl1(){
        return termUrl1.isEnabled();
    }
    public boolean clickTermUrl2(){
        return termUrl2.isEnabled();
    }

//    逻辑方法
    public void registerService365(String email, String password, String confirmPassword,boolean termButton,boolean regButton){
        this.setRegisterEmail(email);
        this.setRegisterPassword(password);
        this.setRegisterConfirmPassword(confirmPassword);
        this.clickTermUrl1();
        this.clickRegister();
    }

}
