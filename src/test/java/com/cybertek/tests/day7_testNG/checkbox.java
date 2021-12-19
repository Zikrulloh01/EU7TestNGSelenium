package com.cybertek.tests.day7_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class checkbox{


    WebDriver driver;



    @BeforeMethod
    public void signIn(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
    }


    @Test
    public void test1(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        String idAttribute = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        for ( int i = 2; i < 10; i ++ ) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertTrue(driver.findElement(By.id(idAttribute)).isSelected());
        }
    }



    @Test
    public void test2(){
        test1();
        WebElement uncheckButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckButton.click();
        String idAttribute = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        for ( int i = 2; i < 10; i ++ ) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertFalse(driver.findElement(By.id(idAttribute)).isSelected());
        }

    }


    @Test
    public void test3(){
        ArrayList <String> names = new ArrayList<>();
        String name = "Bob Feather";
        String personLocator = "(//*[contains(text(),'" + name + "')])//preceding-sibling::td";
        driver.findElement(By.xpath(personLocator)).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        for (int i = 2; i < 9; i ++){
            String locator = "(//*[@id = 'ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector'])/../../td[2]";
            names.add(driver.findElement(By.xpath(locator)).getText());
        }
        System.out.println(names);
        Assert.assertFalse(names.contains(name));
    }




    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }






}
