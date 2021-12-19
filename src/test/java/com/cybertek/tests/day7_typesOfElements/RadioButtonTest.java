package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement blueRadio = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadio = driver.findElement(By.cssSelector("#red"));


        System.out.println("blueRadio.isSelected() = " + blueRadio.isSelected());
        System.out.println("redRadio.isSelected() = " + redRadio.isSelected());

        // I am expecting blue is selected so I use assertTrue()
        Assert.assertTrue(blueRadio.isSelected(), "Verify that blue is selected");

        // I am expecting red is not selected, so I use assertFalse()
        Assert.assertFalse(redRadio.isSelected(), "Verify that red is Not selected");


        redRadio.click(); // I select red radio


        // I am expecting blue radio is not selected so isSelected returns false, I use assertFalse()
        Assert.assertFalse(blueRadio.isSelected(), "Verify that blue is selected");
        // I am expecting red radio is selected so isSelected() returns true, I use assertTrue() it checks the condition against a true value
        Assert.assertTrue(redRadio.isSelected(), "Verify that red is NOT selected");

        Thread.sleep(3000);
        driver.quit();

    }


    @Test
    public void test2(){

    }

}
