package com.service365.customerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    public void clickFirstOrder() {
        firstOrder.click();
    }

    public void clickRandomOrder() {
//        the amount of order
        int number = orderList.findElements(By.className("row")).size();
//        pick up orders with "waiting service provider to confirm"
        List<WebElement> list = orderList.findElements(By.xpath("//span[contains(text(),'waiting service provider to confirm')]"));
        Point point = list.get((int) Math.random() * (list.size())).getLocation();
        point.move(100, 100);
//        i.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/div[1]/div[2]/div/a")).click();

        orderList.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div/div[" + (int) (Math.random() * number) + "]/div[2]/div/a")).click();

    }
}
