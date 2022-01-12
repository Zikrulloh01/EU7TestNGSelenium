package com.cybertek.tests.day9_PopUpsandAlerts.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpForMailingList {

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
    public void signUp() throws InterruptedException {

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String emailSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        driver.get("https://www.tempmailaddress.com/");

        String email = driver.findElement(By.id("email")).getText();

        driver.get("http://practice.cybertekschool.com/");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Zikrulloh Islomov");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String actualSignUpMsg = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualSignUpMsg,expectedMessage,"Sign up success message Fail");
        Thread.sleep(4000);

        driver.navigate().to("https://www.tempmailaddress.com/");

        String actualEmailAddress = driver.findElement(By.xpath("(//*[@id='schranka']//tr)[1]")).getText();
        Assert.assertTrue(actualEmailAddress.contains(expectedEmail), "Email Address Failed");
        driver.findElement(By.xpath("(//*[@id='schranka']//tr)[1]")).click();


        String actualEmail = driver.findElement(By.id("odesilatel")).getText();
        String actualSubject = driver.findElement(By.id("predmet")).getText();

        Assert.assertEquals(actualEmail,expectedEmail, "Email Failed");
        Assert.assertEquals(actualSubject, emailSubject, "Subject Failed");



    }

}
