package com.cybertek.tests.reviews.Announcement_Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class w3schools_TC001 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void doubleClick(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.findElement(By.id("accept-choices")).click();
        WebElement iframe = driver.findElement(By.xpath("//*[@id='iframeResult']"));

        driver.switchTo().frame(iframe);
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("demo"))).perform();

        String colorAttr = driver.findElement(By.id("demo")).getAttribute("style");
        System.out.println(colorAttr);

        Assert.assertTrue(colorAttr.contains("red"));


    }
}
