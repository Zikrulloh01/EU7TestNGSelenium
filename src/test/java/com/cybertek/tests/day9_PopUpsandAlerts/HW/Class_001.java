package com.cybertek.tests.day9_PopUpsandAlerts.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class_001 {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/");
        String expectedErrorMessage = "The date of birth is not valid";
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement inputDateOfBirth = driver.findElement(By.xpath("//*[@name='birthday']"));
        inputDateOfBirth.sendKeys("wrong_dob");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@data-bv-for='birthday'][2]"));
        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message Verification");
    }



    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement checkboxCpp = driver.findElement(By.id("inlineCheckbox1"));
        WebElement checkboxJava = driver.findElement(By.id("inlineCheckbox2"));
        WebElement checkboxJS = driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(checkboxCpp.isDisplayed(), "C++ checkbox is displayed");
        Assert.assertTrue(checkboxCpp.isEnabled(), "C++ checkbox is not clickable");
        Assert.assertTrue(checkboxJava.isDisplayed(), "Java checkbox is displayed");
        Assert.assertTrue(checkboxJava.isEnabled(), "Java checkbox is not clickable");
        Assert.assertTrue(checkboxJS.isDisplayed(), "JS checkbox is displayed");
        Assert.assertTrue(checkboxJS.isEnabled(), "JS checkbox is not clickable");

        String cppText = driver.findElement(By.xpath("//*[@for='inlineCheckbox1']")).getText();
        String javaText = driver.findElement(By.xpath("//*[@for='inlineCheckbox2']")).getText();
        String jsText = driver.findElement(By.xpath("//*[@for='inlineCheckbox3']")).getText();

        System.out.println("cppText = " + cppText);
        System.out.println("javaText = " + javaText);
        System.out.println("jsText = " + jsText);

        Assert.assertEquals(cppText, "C++", "CPP text failed");
        Assert.assertEquals(javaText, "Java", "Java text failed");
        Assert.assertEquals(jsText, "JavaScript", "Js text failed");


    }


    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";

        WebElement fNameInput = driver.findElement(By.name("firstname"));
        fNameInput.sendKeys("z");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@data-bv-for='firstname'][2]"));

        Assert.assertEquals(errorMessage.getText(), expectedMessage, "Error message failed");
        System.out.println("errorMessage.getText() = " + errorMessage.getText());

    }
}
