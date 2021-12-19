package com.cybertek.tests.day4_6Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocator_TC02 {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        String actualUrl = "http://practice.cybertekschool.com/sign_up";

        WebElement fullName = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement loginButton = driver.findElement(By.name("wooden_spoon"));
        fullName.sendKeys("Zikrulloh Islomov");
        email.sendKeys("zikrillo@yahoo.com");
        loginButton.click();

        if (!actualUrl.equals(driver.getCurrentUrl())){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        driver.quit();
    }

}
