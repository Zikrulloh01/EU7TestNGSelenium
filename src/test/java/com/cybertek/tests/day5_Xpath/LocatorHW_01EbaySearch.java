package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_01EbaySearch {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.ebay.co.uk/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        searchBox.sendKeys("term");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"gh-btn\" and @value=\"Search\"]"));
        searchButton.click();
        WebElement testResult = driver.findElement(By.xpath("//h1[@class=\"srp-controls__count-heading\"]"));


        System.out.println(testResult.getText());
        Thread.sleep(3000);

        driver.quit();


    }

}
