package com.cybertek.tests.day7_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterMethod {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.get("https://apple.com/");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://bbc.co.uk/");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test3() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.get("https://kun.uz/");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test4(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }

    @Test
    public void test5(){
        String email = "mike@Smith.com";
        Assert.assertTrue(email.contains("@"), "Verify email contains @");
    }

    @Test
    public void test6(){
        Assert.assertFalse(0==1, "Verify that 0 is greater than 1");
    }


    @Test
    public void test7(){
        Assert.assertNotEquals(25,"25");
    }


    @BeforeMethod
    public void setUp(){
        System.out.println("BEFORE METHOD");
        System.out.println("WebDriver, Open Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("Closing,Browser, Quit");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("===---After Class---===");
        System.out.println("Some reports are here.");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("===---Before Class---===");
        System.out.println("Test case starts here.");
    }


}
