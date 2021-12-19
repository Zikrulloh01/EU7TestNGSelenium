package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class uberTest {

    WebDriver driver;
    @BeforeClass
    public void start(){
        System.out.println("Welcome to uber eats");
        System.out.println("Your food starts here");
        System.out.println("------======------");
    }

    @BeforeMethod
    public void goToWeb() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ubereats.com/gb");
        //driver.findElement(By.cssSelector("button[class='bc gg gh gk bj bk bl bm bn bo bt bu ba bb']")).click();

        driver.findElement(By.id("location-typeahead-home-input")).sendKeys("E140DF");
        driver.findElement(By.cssSelector("div.hf")).click();
        driver.findElement(By.cssSelector("button[class='bc gg gh gk bj bk bl bm bn bo bt bu ba bb']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test1(){
        System.out.println("Started successfully");
    }




    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    @AfterClass
    public void bye(){
        System.out.println("-------=========----------");
        System.out.println("Thanks for eating with us");
    }




}
