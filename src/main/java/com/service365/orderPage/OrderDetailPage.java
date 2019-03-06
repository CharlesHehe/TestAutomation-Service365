package com.service365.orderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class OrderDetailPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[1]/div[1]/div[1]")
    WebElement orderNumber;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[1]/div[1]/div[2]/table/tbody/tr[7]/td/span")
    WebElement orderWaiting;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[1]/div[1]/div[2]/div[1]")
    WebElement topNote;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[1]/div[1]/div[2]/div[2]/small/a")
    WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[2]/div[1]/div[2]/address/p[2]")
    WebElement orderStatus2;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[2]/div[1]/div[2]/address/p[3]")
    WebElement orderStatus3;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[2]/div[1]/div[2]/address/p[4]")
    WebElement orderStatus4;
    @FindBy(xpath = "//*[@id=\"Message\"]")
    WebElement messageInput;
    @FindBy(xpath = "//*[@id=\"myForm\"]/fieldset/div[2]/div/button")
    WebElement messageSubmit;
    @FindBy(xpath = "//*[@id=\"confirm\"]/div/div/div[3]/button[1]")
    WebElement alertYes;


    public OrderDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String orderNumber() {
        return orderNumber.getText();
    }

    public String orderWaiting() {
        return orderWaiting.getText();
    }

    public String topNote() {
        return topNote.getText();
    }

    public void clickcCancelButton() {
        cancelButton.click();
    }

    public String orderStatus2() {
        return orderStatus2.getText();
    }

    public String orderStatus3() {
        return orderStatus3.getText();
    }
    public String orderStatus4(){
        return orderStatus4.getText();
    }
    public void setMessageInput(String s){
        messageInput.sendKeys(s);
    }
    public void clickMessageSubmit(){
        messageSubmit.click();
    }
    public void acceptAlert(){
        alertYes.click();
    }



//    逻辑代码
    public void serviceStatus(){
        System.out.println(orderNumber());
        Assert.assertEquals(orderWaiting(), "waiting service provider to confirm");
        System.out.println(topNote());
        Assert.assertEquals(orderStatus2(), "Service time confirmed by customer");
        Assert.assertEquals(orderStatus3(), "Provider to confirm service time");
    }
}
