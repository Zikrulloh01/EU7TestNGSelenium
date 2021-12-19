package com.cybertek.tests.day7_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class appleTest {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeClass
    public void getUrl(){
        driver.get("https://www.apple.com/uk/shop/mac/accessories");
    }

    @Test
    public void chooseMac(){
        driver.findElement(By.cssSelector(".ac-gn-link-mac")).click();
        driver.findElement(By.cssSelector(".chapternav-item-imac")).click();
        driver.findElement(By.cssSelector(".chapternav-item-imac-24")).click();
    }

    @Test
    public void getStartPrice(){
        System.out.println("Starting price is: " + driver.findElement(By.cssSelector(".intro-price")).getText());
    }
    @Test
    public void goShoppingAccessories(){
        driver.findElement(By.cssSelector("a.button")).click();
    }

    @Test
    public void getKeyboardPrice(){
        WebElement price = driver.findElement(By.xpath("(//span[@class='as-pinwheel-pricecurrent'])[3]"));

        System.out.println(price.getText());
    }


    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }





}
