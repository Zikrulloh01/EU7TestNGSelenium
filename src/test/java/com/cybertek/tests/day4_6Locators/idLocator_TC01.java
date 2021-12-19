package com.cybertek.tests.day4_6Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class idLocator_TC01 {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));

        dontClickButton.click();

    }

}
