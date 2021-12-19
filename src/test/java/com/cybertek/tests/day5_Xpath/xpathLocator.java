package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xpathLocator {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       // driver.findElement(By.xpath("//button[@onclick=\"button2()\"]")).click();
        driver.findElement(By.xpath("//*[@name=\"button2\"]")).click();

        Thread.sleep(4000);

        driver.quit();


    }

}
