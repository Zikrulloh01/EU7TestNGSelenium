package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class isDisplayed {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");


        WebElement inputUsername = driver.findElement(By.cssSelector("#username"));


        Assert.assertFalse(inputUsername.isDisplayed(), "The input username is Not displayed");

        WebElement startButton = driver.findElement(By.cssSelector("#start>.btn.btn-primary"));
        startButton.click();
        Thread.sleep(6000);

        Assert.assertTrue(inputUsername.isDisplayed(), "The username input is displayed");


        Thread.sleep(3000);
        driver.quit();




    }

}
