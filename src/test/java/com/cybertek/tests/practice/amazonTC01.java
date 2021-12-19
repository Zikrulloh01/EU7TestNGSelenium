package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTC01 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        String expectedUrl = "https://www.amazon.co.uk/s?k=computer+desk&ref=nb_sb_noss";
        String expectedText = "\"computer desk\"";
        driver.get("https://www.amazon.co.uk/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("computer desk");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        if (expectedUrl.equals(driver.getCurrentUrl())){
            System.out.println("\"Url: PASS\"");
        }
        else{
            System.out.println("\"URL FAIL\"");
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            System.out.println("expectedUrl = " + expectedUrl);
        }

        WebElement searchText = driver.findElement(By.className("a-color-state"));
        if (searchText.getText().equals(expectedText)){
            System.out.println("\"Text: PASS\"");
        }
        else{
            System.out.println("\"Text: FAIL\"");
        }





    }
}
