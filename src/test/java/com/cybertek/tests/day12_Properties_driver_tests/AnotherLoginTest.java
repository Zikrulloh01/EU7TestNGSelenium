package com.cybertek.tests.day12_Properties_driver_tests;

import com.cybertek.tests.TestBase;
import static com.cybertek.utilities.ConfigurationReader.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class AnotherLoginTest extends TestBase {


    @Test
    public void test1(){
        driver.get(getKey("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(getKey("driver_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(getKey("driver_password") + Keys.ENTER);

    }
}
