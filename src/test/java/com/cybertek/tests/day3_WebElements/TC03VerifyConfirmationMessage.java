package com.cybertek.tests.day3_WebElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC03VerifyConfirmationMessage {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        String actualUrl = "http://practice.cybertekschool.com/forgot_password";
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        driver.manage().window().maximize();
        driver.get(actualUrl);
        String expectedEmail = "zikrillo@yahoo.com";
        WebElement inputField = driver.findElement(By.name("email"));
        inputField.sendKeys("zikrillo@yahoo.com");
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        String actualEmail = inputField.getAttribute("value");
        if (expectedEmail.equals(actualEmail)){
            System.out.println("Email Test: PASS");
        }
        else{
            System.out.println("Email Test: FAIL");
        }
        retrievePasswordButton.click();


        String expectedMessage = "Your e-mail's been sent!";
        WebElement actualMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualMessage.getText());
        if (expectedMessage.equals(actualMessage.getText())){
            System.out.println("Message Test: PASS");
        }
        else{
            System.out.println("Message Test: FAIL");
        }

        driver.quit();
    }
}
