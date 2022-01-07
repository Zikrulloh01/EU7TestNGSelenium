package com.cybertek.tests.day10_actions_js;

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

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        for (int i = 0; i < 3; i++) {
            String user = "name: user" + (i+1);
            String userPath = "(//h5)[" + (i + 1) + "]";
            String xpath = "(//img)[" + (i+1) + "]";
            WebElement img = driver.findElement(By.xpath(xpath));
            WebElement userText = driver.findElement(By.xpath(userPath));
            actions.moveToElement(img).pause(2000).perform();
            System.out.println(userText.getText());
            Assert.assertTrue(userText.isDisplayed());
        }






    }
}
