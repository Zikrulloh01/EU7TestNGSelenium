package com.cybertek.tests.day9_PopUpsandAlerts;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class multipleWindows {
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
    public void twoWindowHandling(){

        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before new Window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after a new Window: " + driver.getTitle());

        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!currentHandle.equals(handle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after Switch: " + driver.getTitle());

    }


    @Test
    public void multipleWindowHandling(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before new Window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after a new Window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        driver.findElement(By.linkText("Click Here")).click();
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        String expectedWindow = "New Window";

        for (String handle : handles) {
            // change the window one by one and see if the new window title matches with the expected one, if so break the loop;
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(expectedWindow)){
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

}
