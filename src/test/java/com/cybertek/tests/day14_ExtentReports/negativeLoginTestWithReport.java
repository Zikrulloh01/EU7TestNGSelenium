package com.cybertek.tests.day14_ExtentReports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import static com.cybertek.utilities.ConfigurationReader.*;

import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class negativeLoginTestWithReport extends TestBase {



    @Test(priority = 1)
    public void wrongUsername(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong Username Test");
        extentLogger.info("Login using username and password, click login button");
        loginPage.logIn(getKey("wrongUsername"), getKey("driver_password"));
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Passed");
    }

    @Test(priority = 2)
    public void wrongPassword(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong Password Test");
        extentLogger.info("Login using username and password, click login button");
        loginPage.logIn(getKey("driver_username"), getKey("wrongPassword"));
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        extentLogger.pass("Passed");
    }


}
