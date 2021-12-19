package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHw_03WikipediaSearch {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://wikipedia.org/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"searchInput\" and @name=\"search\"]"));

        searchBox.sendKeys("selenium webdriver");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"pure-button pure-button-primary-progressive\"]"));
        searchButton.click();
        WebElement link = driver.findElement(By.xpath("//a[@title=\"Selenium (software)\"]"));
        link.click();
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.quit();

    }

}
