package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class phpTravelsTest {

    WebDriver driver;


    @BeforeMethod
    public void login() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/login");
        String expectedUrl = "https://www.phptravels.net/account/dashboard";

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-lg"));
        email.sendKeys("user@phptravels.com");
        password.sendKeys("demouser");
        loginButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());


    }
    @Test
    public void testUsername(){
        WebElement usernameOnHome = driver.findElement(By.cssSelector("span[style=\"text-transform:capitalize\"]"));
        String expectedUsername = "Demo";

        Assert.assertEquals(usernameOnHome.getText(), expectedUsername);
    }

    @Test
    public void testTimeZone(){
        WebElement timeDetails = driver.findElement(By.id("ct"));
        String expectedZone = "Greenwich";

        Assert.assertTrue(timeDetails.getText().contains(expectedZone));
    }


    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
