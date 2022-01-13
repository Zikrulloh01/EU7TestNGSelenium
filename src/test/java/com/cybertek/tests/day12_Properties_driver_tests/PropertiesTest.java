package com.cybertek.tests.day12_Properties_driver_tests;

import static com.cybertek.utilities.ConfigurationReader.*;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(getKey("browser"));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




    @Test
    public void test1(){
        driver.get(getKey("url"));
        System.out.println("get(\"browser\") = " + getKey("browser"));
        System.out.println("get(\"url\") = " + getKey("url"));
    }

    @Test
    public void logIn(){
        driver.get(getKey("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(getKey("driver_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(getKey("driver_password") + Keys.ENTER);
    }


}
