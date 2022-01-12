package com.cybertek.tests.day9_PopUpsandAlerts.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUpload {
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
    public void fileUploadTest(){
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir") + "/src/test/resources/file.txt";
        chooseFile.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "File Uploaded!", "File Uploaded Message Failed");
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "file.txt", "File Name Failed");
    }



    @Test
    public void autoCompleteTest(){
        String expectedMsg = "You selected: United States of America";
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@onclick='log()']")).click();
        String actualMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualMessage,expectedMsg, "Message Failed");
    }



    @Test
    public void statusCodesTest(){
        String expectedMsg = "This page returned a 200 status code";
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("200")).click();

        String actualMsg = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }
    @Test
    public void statusCodesTest1(){
        String expectedMsg = "This page returned a 301 status code";
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("301")).click();

        String actualMsg = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }
    @Test
    public void statusCodesTest2(){
        String expectedMsg = "This page returned a 404 status code";
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("404")).click();

        String actualMsg = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }
}
