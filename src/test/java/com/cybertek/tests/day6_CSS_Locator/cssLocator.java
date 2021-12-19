package com.cybertek.tests.day6_CSS_Locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        WebElement dontClick = driver.findElement(By.cssSelector("#disappearing_button"));
        Thread.sleep(2000);
        dontClick.click();
        driver.findElement(By.cssSelector("[name=\"button6\"]")).click();
        Thread.sleep(3000);;
        driver.quit();


    }

}
