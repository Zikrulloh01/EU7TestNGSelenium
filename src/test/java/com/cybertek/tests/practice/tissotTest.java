package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tissotTest {

        WebDriver driver;
    @BeforeMethod
    public void getWebUrl(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.tissotwatches.com/en-gb/");


    }


    @Test
    public void testWatchPrice(){
//        WebElement menButton = driver.findElement(By.xpath("//div[@class=\"main-menu__submenu-container\"]/preceding-sibling::span"));
        WebElement menButton = driver.findElement(By.xpath("(//span[@class='main-menu__item-btn'])[1]"));
        menButton.click();
        driver.findElement(By.xpath("//a[@tabindex='-1'][1]")).click();
        driver.findElement(By.cssSelector("button#btn-cookie-allow")).click();
        driver.findElement(By.id("sorter")).click();

        driver.findElement(By.cssSelector("option[value='https://www.tissotwatches.com/en-gb/men-watches.html?product_list_order=price--asc']")).click();

        String watchName = "TISSOT CLASSIC DREAM";

        WebElement watch = driver.findElement(By.xpath("(//a[@title='Tissot Classic Dream'][1]//h3[@class='product-thumbnail__title'])"));

        Assert.assertEquals(watch.getText(),watchName);

    }



    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
