package com.cybertek.tests.day9_PopUpsandAlerts.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




    @Test
    public void test1(){
        String expectedErrorMessage = "The date of birth is not valid";

        WebElement inputDateOfBirth = driver.findElement(By.xpath("//*[@name='birthday']"));
        inputDateOfBirth.sendKeys("wrong_dob");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@data-bv-for='birthday'][2]"));
        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message Verification");
    }



    @Test
    public void test2(){
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
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";

        WebElement fNameInput = driver.findElement(By.name("firstname"));
        fNameInput.sendKeys("z");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@data-bv-for='firstname'][2]"));

        Assert.assertEquals(errorMessage.getText(), expectedMessage, "Error message failed");
        System.out.println("errorMessage.getText() = " + errorMessage.getText());

    }


    @Test
    public void test4(){
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";

        WebElement lNameInput = driver.findElement(By.name("lastname"));
        lNameInput.sendKeys("v");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@data-bv-for='lastname'][2]"));

        Assert.assertEquals(errorMessage.getText(), expectedMessage, "Error message failed");
        System.out.println("errorMessage.getText() = " + errorMessage.getText());

    }


    @Test
    public void test5() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys("Zikrulloh");
        driver.findElement(By.name("lastname")).sendKeys("Islomov");
        driver.findElement(By.name("username")).sendKeys("islomov");
        driver.findElement(By.name("email")).sendKeys("zikrilloislomov@gmail.com");
        driver.findElement(By.name("password")).sendKeys("zikrillo2001");
        driver.findElement(By.name("phone")).sendKeys("202-555-0160");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("10/20/2001");
        WebElement department = driver.findElement(By.name("department"));
        WebElement jobTitle = driver.findElement(By.name("job_title"));
        Select select = new Select(department);
        select.selectByValue("DE");
        select = new Select(jobTitle);
        select.selectByVisibleText("SDET");
        WebElement checkboxJava = driver.findElement(By.id("inlineCheckbox2"));
        checkboxJava.click();
        driver.findElement(By.id("wooden_spoon")).click();
        String expectedWellDone = "Well done!";
        String successMessage = "You've successfully completed registration!";

        WebElement wellDone = driver.findElement(By.tagName("h4"));
        WebElement successText = driver.findElement(By.tagName("p"));

        Assert.assertEquals(wellDone.getText(), expectedWellDone, "Well Done text fail");
        Assert.assertEquals(successText.getText(), successMessage, "Success message fail");

        Thread.sleep(2000);
    }

}
