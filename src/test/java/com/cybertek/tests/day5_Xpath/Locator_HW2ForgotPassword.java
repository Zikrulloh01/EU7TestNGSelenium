package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator_HW2ForgotPassword {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[@class=\"nav-link\" and contains(., \"Home\")]"));
        WebElement header = driver.findElement(By.xpath("//h2[text()=\"Forgot Password\"]"));
        WebElement email = driver.findElement(By.xpath("//label[@for=\"email\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        WebElement retrieveButton = driver.findElement(By.xpath("//button[@id=\"form_submit\"]"));
        System.out.println(homeLink.getText());
        System.out.println(header.getText());
        System.out.println(email.getText());
        emailInput.sendKeys("zikrillo@yahoo.com");
        System.out.println(emailInput.getAttribute("value+"));
        System.out.println(retrieveButton.getText());

        Thread.sleep(3000);
        driver.quit();


    }

}
