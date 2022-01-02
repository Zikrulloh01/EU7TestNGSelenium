package com.cybertek.tests.day9_PopUpsandAlerts;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframetest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Zikrulloh Islomov");

        // goes back to first main html
        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);
        Thread.sleep(1000);

        driver.findElement(By.id("tinymce")).clear();

        Thread.sleep(1000);

        driver.findElement(By.id("tinymce")).sendKeys("Message after switching back to iframe");

        driver.switchTo().parentFrame();

        Thread.sleep(1000);

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        Thread.sleep(1000);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Message After using parent frame");

    }



    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());



        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

}
