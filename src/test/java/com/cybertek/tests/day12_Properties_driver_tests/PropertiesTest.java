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
        driver = WebDriverFactory.getDriver(get("browser"));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




    @Test
    public void test1(){
        driver.get(get("url"));
        System.out.println("get(\"browser\") = " + get("browser"));
        System.out.println("get(\"url\") = " + get("url"));
    }

    @Test
    public void logIn(){
        driver.get(get("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(get("driver_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(get("driver_password") + Keys.ENTER);
    }

}
