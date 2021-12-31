package com.cybertek.tests.day8_Automation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class selectDropDownTest {

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
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));


        //Passing a dropdown as a parameter for Select Constructor
        Select stateDropdown = new Select(dropdownElement);


        //save all states in the dropdown into a list
        System.out.println("Get all Options: ");
        List<WebElement> options = stateDropdown.getOptions();


        //verify the num of states
        System.out.println("options.size() = " + options.size());
        Assert.assertEquals(options.size(),52, "Verify num of states in the US");


        //print options in the states list
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        String expectedOption = "Select a State";
        String text = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text,expectedOption,"Verify first Selection");




        // How to select a state in the dropdown
        // 1. Select using visible text


        stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(3000);
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Virginia", "Verify Virginia Selected");


        //2. Select using index
        Thread.sleep(2000);

        stateDropdown.selectByIndex(51);
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Wyoming", "Verify Wyoming Selected");

        //3. Select using value

        stateDropdown.selectByValue("TX");
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Texas", "Verify Texas Selected");

    }

}
