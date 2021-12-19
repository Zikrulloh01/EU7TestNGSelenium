package com.cybertek.tests.reviews.week1IntroAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T02_CybertekUrlTask {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("cybertek")){
            System.out.println("Url Pass");
        }
        else{
            System.out.println("Url fail");
        }
        if (driver.getTitle().equals("Practice")){
            System.out.println("Title pass");
        }
        else{
            System.out.println("Title fail");
        }
        driver.close();


    }
}
