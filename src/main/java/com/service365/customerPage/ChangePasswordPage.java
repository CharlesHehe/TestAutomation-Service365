package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"CurrentPassword\"]")
    WebElement currentPassword;
    @FindBy(xpath = "//*[@id=\"NewPassword\"]")
    WebElement newPassword;
    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[4]/div/button")
    WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[4]/div/a")
    WebElement cancelButton;

    public ChangePasswordPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void editCurrentPassword(String password){
        currentPassword.sendKeys(password);
    }
    public void editNewPassword(String password){
        newPassword.sendKeys(password);
    }
    public void editConfirmPassword(String password){
        confirmPassword.sendKeys(password);
    }
    public void clickSubmit(){
        submitButton.click();
    }
    public void clickCancel(){
        cancelButton.click();
    }

//    逻辑方法
    public void changePassword(String currentPassword,String newPassword,String confirmPassword){
        editCurrentPassword(currentPassword);
        editNewPassword(newPassword);
        editConfirmPassword(confirmPassword);
        clickSubmit();
    }
}
