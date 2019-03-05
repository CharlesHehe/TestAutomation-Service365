package com.service365.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"Nickname\"]")
    WebElement nickName;
    @FindBy(xpath = "//*[@id=\"Mobile\"]")
    WebElement contactNumber;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[3]/div/div[2]/label")
    WebElement male;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[3]/div/div[1]/label")
    WebElement female;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[3]/div/div[3]/label")
    WebElement otherGender;
    @FindBy(xpath = "//*[@id=\"Introduction\"]")
    WebElement instruction;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[5]/div/button")
    WebElement submit;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div/div[2]/form/fieldset/div[5]/div/a")
    WebElement cancel;

    public EditProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void editNickName(String newName){
        nickName.clear();
        nickName.sendKeys(newName);
    }
    public void editContactNumber(String newNumber){
        contactNumber.clear();
        contactNumber.sendKeys(newNumber);
    }
    public void editGenderMale(){
        male.click();
    }
    public void editGenderFemale(){
        female.click();
    }
    public void editGenderOther(){
        otherGender.click();
    }
    public void editInstruction(String newIntruction){
        instruction.clear();
        instruction.sendKeys(newIntruction);
    }
    public void sumitButton(){
        submit.click();
    }
    public void cancelButton(){
        cancel.click();
    }
    public void editProfile(String nickName,String contactNumber,String gender,String instroduction){
        editNickName(nickName);
        editContactNumber(contactNumber);
        if(gender.equals("Male")){
            editGenderMale();
        }else if(gender.equals("Female")){
            editGenderFemale();
        }else{
            editGenderOther();
        }
        editInstruction(instroduction);
        sumitButton();
    }
}
