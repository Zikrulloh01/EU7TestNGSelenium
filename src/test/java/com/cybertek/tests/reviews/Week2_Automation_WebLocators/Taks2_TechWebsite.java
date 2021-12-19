package com.cybertek.tests.reviews.Week2_Automation_WebLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Taks2_TechWebsite {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demoblaze.com/index.html");
        String expectedPrice = "790";
        WebElement laptopsLink = driver.findElement(By.linkText("Laptops"));
        laptopsLink.click();
        Thread.sleep(2000);
        WebElement sonyLink = driver.findElement(By.partialLinkText("Sony vaio i7"));
        sonyLink.click();
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//h3[@class='price-container']"));


        char chars [] = price.getText().toCharArray();
        String actualPrice = "";
        for (char c:chars ){
            if (Character.isDigit(c)){
                actualPrice+=c;
            }
        }
        System.out.println(actualPrice);
        if (actualPrice.equals(expectedPrice)){
            System.out.println("Price Pass");
        }
        else{
            System.out.println("Price Fail");
        }
        Thread.sleep(3000);
        driver.quit();
    }

}
