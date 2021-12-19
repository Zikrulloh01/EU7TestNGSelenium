package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {


    @Test
    public void test1(){


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement blueRado = driver.findElement(By.cssSelector("#blue"));
        System.out.println("blueRado.getAttribute(\"type\") = " + blueRado.getAttribute("type"));
        System.out.println("blueRado.getAttribute(\"name\") = " + blueRado.getAttribute("name"));
        System.out.println("blueRado.getAttribute(\"checked\") = " + blueRado.getAttribute("checked"));
        System.out.println(blueRado.getAttribute("href"));// if the attribute does not exist it returns "null".
        System.out.println(driver.findElement(By.cssSelector(".nav-link")).getAttribute("innerHTML"));

        driver.quit();

    }

}
