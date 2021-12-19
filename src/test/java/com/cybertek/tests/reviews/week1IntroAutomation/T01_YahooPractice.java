package com.cybertek.tests.reviews.week1IntroAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T01_YahooPractice {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https:/yahoo.com/");
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Yahoo")){
            System.out.println("It contains yahoo");
        }
        else{
            System.out.println("It does not contain yahoo.");
        }

    }

}
