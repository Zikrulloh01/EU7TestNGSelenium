package com.cybertek.tests.day4_6Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class className_TC04 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");// get a browser
        driver.manage().window().maximize();// maximize the browser window

        driver.get("http://practice.cybertekschool.com/sign_up"); // go to the url

        WebElement homeLink = driver.findElement(By.className("nav-link"));

        homeLink.click();


        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println("The header is: " + driver.findElement(By.className("h3")).getText());


    }
}
