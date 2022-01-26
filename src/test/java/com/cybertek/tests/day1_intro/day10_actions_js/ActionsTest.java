package com.cybertek.tests.day1_intro.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {
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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed());

    }

    @Test
    public void dragDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        WebElement item = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2999);
        actions.dragAndDrop(item,target).perform();


        //actions.moveToElement(item).clickAndHold().moveToElement(target).pause(2000).release().perform();

        Assert.assertEquals(target.getText(), "You did great!", "Drag drop fail");


    }

    @Test
    public void dragDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        WebElement item = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2999);


        actions.moveToElement(item).clickAndHold().moveToElement(target).pause(2000).release().perform();

        Assert.assertEquals(target.getText(), "You did great!", "Drag drop fail");


    }




}
