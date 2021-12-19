package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class facebookLogin {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        String homePageUrl = "https://facebook.com";
        String expectedUrl = "https://www.facebook.com/?sk=welcome";
        driver.get("https://facebook.com/");
        String email = "zikrillo@yahoo.com";
        String password = "12345asdfg";

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);
        WebElement passInput = driver.findElement(By.id("pass"));
        passInput.sendKeys(password);

        WebElement cookiesButton = driver.findElement(By.xpath("//button[@title=\"Allow All Cookies\"]"));
        cookiesButton.click();
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();


        if (expectedUrl.equals(driver.getCurrentUrl())){
            System.out.println("\"Login PASS\"");
        }
        else{
            System.out.println("Login FAIL");
        }


    }
}
