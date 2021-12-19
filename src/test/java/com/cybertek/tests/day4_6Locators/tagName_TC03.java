package com.cybertek.tests.day4_6Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class tagName_TC03 {


    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullname = driver.findElement(By.tagName("input"));
        WebElement email = driver.findElement(By.name("email"));

        fullname.sendKeys("Ziktillo Islomov");
        email.sendKeys("zikrillo@yahoo.com");

        driver.findElement(By.tagName("button")).click();

        sleep(3000);
        driver.quit();


    }

}
