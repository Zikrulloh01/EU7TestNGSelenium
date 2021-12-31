package com.cybertek.tests.day8_Automation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class listOfElements {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // save all buttons on the page into a list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Num of buttons: " + buttons.size());

        Assert.assertEquals(buttons.size(), 6, "Verify button size");

        for (WebElement button : buttons) {
            Assert.assertTrue(button.isDisplayed());
        }



        //click second button
        buttons.get(1).click();
    }


    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // it will not throw an Exception error NoSuchElement it just creates the list and list is going to be 0 size;
        List<WebElement> buttons = driver.findElements(By.tagName("butto0n"));// if there is a wrong locator with find.elements() it does not give exception
                                                                             // That's why we always have to verify list size with the expected result. In the wrong case of locator the list size is 0;


    }

}
