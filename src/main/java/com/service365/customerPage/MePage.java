package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[1]/div/div[1]/a")
    WebElement image;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[1]/div/div[2]/h3")
    WebElement bio;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[4]/a")
    WebElement address;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div[2]/a")
    WebElement editProfileOn;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div[3]/table/tbody/tr[4]/td/span")
    WebElement overallRating;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[2]/form/a[1]")
    WebElement changePicture;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[2]/form/a[2]")
    WebElement editProfile;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[2]/form/a[3]")
    WebElement changePassword;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[2]/a")
    WebElement service;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[3]/a")
    WebElement order;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div[1]/table/tbody/tr[2]/td")
    WebElement nickName;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div[1]/table/tbody/tr[3]/td")
    WebElement contactNumber;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[1]/div/div[2]/p")
    WebElement instruction;

    public MePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String nickNameCheck(){
        return nickName.getText();
    }
    public String instructionCheck(){
        return instruction.getText();
    }
    public String editProfileOnCheck(){
        return editProfileOn.getAttribute("href");
    }
    public String overallRatingCheck(){
        return overallRating.getAttribute("title");
    }
    public String contactNumberCheck(){
        return contactNumber.getText();
    }
    public String bioCheck(){
        return bio.getText();
    }
    public String imageCheck() {
        return image.getAttribute("style");
    }

    public void clickAddress() {
        address.click();
    }
    public void changePicture() {

        changePicture.sendKeys("D:/anotherPig.jpg");
    }

    public void clickEditProfile() {
        editProfile.click();
    }

    public void clickChangePassword() {
        changePassword.click();
    }

    public void clickService(){
        service.click();
    }
    public void clickOrder(){
        order.click();
    }
}
