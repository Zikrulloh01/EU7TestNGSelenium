package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class checkBoxHW {

    @Test
    public void logIn() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkAll() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        String idAttribute = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        for ( int i = 2; i < 10; i ++ ) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertTrue(driver.findElement(By.id(idAttribute)).isSelected());
        }
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void uncheckAll() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        String idAttribute = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        for ( int i = 2; i < 10; i ++ ) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertTrue(driver.findElement(By.id(idAttribute)).isSelected());
        }
        WebElement uncheckButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckButton.click();
        for ( int i = 2; i < 10; i ++ ) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertFalse(driver.findElement(By.id(idAttribute)).isSelected());
        }
        Thread.sleep(3000);
        driver.quit();

    }


    @Test
    public void deleteAPerson() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
        WebElement deletedPerson = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        deletedPerson.click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        Assert.assertNotEquals(deletedPerson,driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector")));


        Thread.sleep(3000);
        driver.quit();
    }


}
