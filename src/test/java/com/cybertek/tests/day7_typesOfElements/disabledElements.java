package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class disabledElements {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement greenRadio = driver.findElement(By.cssSelector("#green"));
        if (greenRadio.isEnabled()){
            greenRadio.click();
        }
        else{
            System.out.println("The button is not enabled");
        }

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        String expectedText = "Zikrulloh Islomov";

        WebElement textArea = driver.findElement(By.cssSelector("#input-example>input"));
        WebElement enableButton = driver.findElement(By.cssSelector("[onclick=\"swapInput()\"]"));

        enableButton.click();
        Thread.sleep(5000);
        textArea.sendKeys("Zikrulloh Islomov");
        Assert.assertEquals(expectedText, textArea.getAttribute("value"));

        enableButton.click();

        Thread.sleep(3000);

        Assert.assertFalse(textArea.isEnabled());

        Thread.sleep(2000);

        driver.quit();


    }



}
