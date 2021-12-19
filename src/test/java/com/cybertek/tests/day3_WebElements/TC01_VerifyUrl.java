package com.cybertek.tests.day3_WebElements;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_VerifyUrl {

    public static void main(String[] args) {

        String actualUrl = "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get(actualUrl);
//        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
//        retrievePasswordButton.click();
        driver.findElement(By.className("radius")).click();

        if (driver.getCurrentUrl().equals(actualUrl)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
        driver.quit();

    }

}
