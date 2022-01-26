package com.cybertek.tests.day15;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {



    @Test
    public void test1(){
        extentLogger = report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ContactPage contactPage = new ContactPage();
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        // Logs in as sales manager
        extentLogger.info("Log in as sales Manager using login method");
        loginPage.logInAsSalesManager();

        dashboardPage.waitUntilLoaderScreenDisappear();
        // Navigate To Customers contact Page
        extentLogger.info("Navigate To Customers contact Page");
        dashboardPage.navigateToModule("Customers", "Contacts");


        dashboardPage.waitUntilLoaderScreenDisappear();
        // Click On intended email
        extentLogger.info("Click On intended email");
        contactPage.getEmail("mbrackstone9@example.com").click();


        String expectedPhoneNum = "+18982323434";
        String expectedFullName = "Mariam Brackstone";
        String expectedEmail = "mbrackstone9@example.com";

        // Verify FullName
        extentLogger.info(" Verify FullName");
        Assert.assertEquals(contactInfoPage.fullName.getText(), expectedFullName);
        // Verify Email
        extentLogger.info(" Verify Email");
        Assert.assertEquals(contactInfoPage.email.getText(), expectedEmail);
        // Verify Phone Number
        extentLogger.info("Verify Phone Number");
        Assert.assertEquals(contactInfoPage.phoneNumber.getText(), expectedPhoneNum, "Phone Number Fail");

        extentLogger.pass("Passed");
    }

}
