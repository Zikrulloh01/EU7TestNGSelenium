package com.cybertek.tests.day4_6Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextLocator_TC05 {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement l1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        l1.click();
        driver.navigate().back();
        WebElement l2 = driver.findElement(By.partialLinkText("Example 2"));
        l2.click();
        driver.findElement(By.className("nav-link")).click();
        driver.quit();
    }
}
