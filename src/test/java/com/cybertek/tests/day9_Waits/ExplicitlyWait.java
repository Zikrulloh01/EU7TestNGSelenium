package com.cybertek.tests.day9_Waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");


        driver.findElement(By.tagName("button")).click();

        WebElement  usernameInput = driver.findElement(By.id("username"));

        // How to wait Explicitly
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys("Zikrulloh2001");


    }


    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Hello2001");
    }
}
