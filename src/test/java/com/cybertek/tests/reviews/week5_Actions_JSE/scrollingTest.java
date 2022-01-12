package com.cybertek.tests.reviews.week5_Actions_JSE;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class scrollingTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void moveToElement() throws InterruptedException {

        Actions actions =  new Actions(driver);

        actions.moveToElement(driver.findElement(By.linkText("Cybertek School"))).perform();

        Thread.sleep(2000);



        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_DOWN, Keys.PAGE_UP);
        Thread.sleep(3000);

    }

}
