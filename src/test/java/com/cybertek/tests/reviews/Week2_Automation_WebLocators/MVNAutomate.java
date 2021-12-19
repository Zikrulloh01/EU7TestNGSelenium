package com.cybertek.tests.reviews.Week2_Automation_WebLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MVNAutomate {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://mvnrepository.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"query\"]"));

        searchBox.sendKeys("WebDriverManager");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]//input[@class=\"button\"]"));

        searchButton.click();





    }
}
