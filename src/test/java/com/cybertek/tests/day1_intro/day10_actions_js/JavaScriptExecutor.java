package com.cybertek.tests.day1_intro.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void clickWithJs(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));


        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",dropdownLink);
    }

    @Test
    public void typeWithJs(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputField = driver.findElement(By.cssSelector("#input-example>input"));

        String text = "Hello disabled input";

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].setAttribute('value',' "+ text + "')",inputField);
    }



    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");

        }
    }

    //This scrolls down directly to the located element
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));

        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);






    }


}
