package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {


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

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String projectPath = System.getProperty("user.dir") + "/" + "src/test/resources/file.txt";
        chooseFile.sendKeys(projectPath);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
        String expectedName = "file.txt";
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), expectedName, "File name Fail");


    }

}
