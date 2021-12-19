package com.cybertek.tests.reviews.Week2_Automation_WebLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWautomation {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://ebay.co.uk/");
        //WebElement searchBox = driver.findElement(By.id("gh-ac")); id Locator
        //WebElement searchBox = driver.findElement(By.name("_nkw")); name locator
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        String expectedItem = "selenium";
        searchBox.sendKeys(expectedItem);

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement resultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String arr [] = resultElement.getText().split(" ");
        System.out.println("Search result is: " + arr[0]);
        if (driver.getTitle().contains(expectedItem)){
            System.out.println("Title PASS");
        }
        else{
            System.out.println("Title FAIL");
        }
        Thread.sleep(3000);
        driver.quit();




    }
}
