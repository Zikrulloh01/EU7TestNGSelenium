package com.cybertek.tests.day3_WebElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC02VerifyUrlChanged {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        String actualUrl = "http://practice.cybertekschool.com/forgot_password";
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        driver.manage().window().maximize();
        driver.get(actualUrl);

        WebElement inputField = driver.findElement(By.name("email"));
        inputField.sendKeys("zikrillo@yahoo.com");
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        if (driver.getCurrentUrl().equals(expectedUrl)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

    }

}
