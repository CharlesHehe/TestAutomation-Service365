package com.service365.customerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/div[1]/div[2]/div/a")
    WebElement firstOrder;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div")
    WebElement orderList;

    public MyOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickFirstOrder(){
        firstOrder.click();
    }
    public void clickRandomOrder(){
        int number=orderList.findElements(By.className("row")).size();
//        随机选取一个order点击view detail
        orderList.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/div["+(int)(Math.random() * number)+"]/div[2]/div/a")).click();

    }
}
