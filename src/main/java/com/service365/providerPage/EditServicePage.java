package com.service365.providerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EditServicePage {
    //    https://dev.service365.co.nz/Service/Edit
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[1]/div/div/button/div/div/div")
    WebElement cityTown;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[2]/div/div/div/div[1]/input")
    WebElement category;
    @FindBy(xpath = "//*[@id=\"Title\"]")
    WebElement title;
    @FindBy(xpath = "//*[@id=\"PricePrefix\"]")
    WebElement pricePrefix;
    @FindBy(xpath = "//*[@id=\"Price\"]")
    WebElement price;
    @FindBy(xpath = "//*[@id=\"PriceSuffix\"]")
    WebElement priceSuffix;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[6]/div/div/button/div/div/div")
    WebElement duration;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[7]/div/div/button/div/div/div")
    WebElement blockedMinutesBeforeBooking;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[8]/div/div/button/div/div/div")
    WebElement blockedMinutesAfterBooking;
    @FindBy(xpath = "//*[@id=\"Summary\"]")
    WebElement summary;
    @FindBy(xpath = "//*[@id=\"editor\"]")
    WebElement description;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[13]/div/button")
    WebElement save;
    @FindBy(xpath = "//*[@id=\"form1\"]/fieldset/div[11]/input")
    WebElement imageUpload;

    public EditServicePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void editCityTown() throws Exception {
        Select select = new Select(cityTown);
        select.selectByIndex(2);
        Thread.sleep(5000);

    }

    public void editCategory() throws Exception {
        Select select = new Select(category);
        select.selectByIndex(2);
        Thread.sleep(5000);

    }
    public void editDuration() throws Exception {
        Select select = new Select(duration);
        select.selectByIndex(2);
        Thread.sleep(5000);

    }
    public void editBlockedMinutesBeforeBooking() throws Exception {
        Select select = new Select(blockedMinutesBeforeBooking);
        select.selectByIndex(2);
        Thread.sleep(5000);

    }
    public void editBlockedMinutesAfterBooking() throws Exception {
        Select select = new Select(blockedMinutesAfterBooking);
        select.selectByIndex(2);
        Thread.sleep(5000);

    }
    public void uploadImage(String imageFile){
        imageUpload.sendKeys(imageFile);
    }

    public void editTitle(String t) {
        title.sendKeys(t);
    }

    public void editPrice(String prefix, String money, String suffix) {
        pricePrefix.sendKeys(prefix);
        price.sendKeys(money);
        priceSuffix.sendKeys(suffix);
    }

    public void editSummary(String s) {
        summary.sendKeys(s);
    }

    public void editDescription(String d) {
        description.sendKeys(d);
    }
    public void clickSave(){
        save.click();
    }



//    逻辑方法
    public void editService(String title,String prefix,String price,String suffix,String summary,String description,String imageFile)throws Exception{
//        editCityTown();
//        editCategory();
        editTitle(title);
        editPrice(prefix,price,suffix);
//        editDuration();
//        editBlockedMinutesBeforeBooking();
//        editBlockedMinutesAfterBooking();
        editSummary(summary);
        editDescription(description);
        uploadImage(imageFile);
        clickSave();
    }
}
