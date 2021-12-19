package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");


        WebElement check1 = driver.findElement(By.cssSelector("#box1"));
        WebElement check2 = driver.findElement(By.cssSelector("#box2"));


        System.out.println("check1.isSelected() = " + check1.isSelected());
        System.out.println("check2.isSelected() = " + check2.isSelected());


        Assert.assertFalse(check1.isSelected(), "Checkbox 1 is not Selected");
        Assert.assertTrue(check2.isSelected(), "Checkbox 2 is selected");

        check1.click();

        Assert.assertTrue(check1.isSelected(), "Checkbox 1 is selected");


        Thread.sleep(2000);
        driver.quit();

    }

}
