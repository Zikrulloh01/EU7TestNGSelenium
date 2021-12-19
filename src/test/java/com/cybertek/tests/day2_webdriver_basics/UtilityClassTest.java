package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class UtilityClassTest {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your browser type: ");
        String browserType = in.nextLine();

        WebDriver driver = WebDriverFactory.getDriver(browserType);
        // automating the html website that has not been deployed yet on our computer
        driver.get("C:\\Users\\Local User\\Desktop\\AutomationClasses\\login.html");
        System.out.println(driver.getTitle());
    }
}
