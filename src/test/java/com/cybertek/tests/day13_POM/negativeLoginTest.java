package com.cybertek.tests.day13_POM;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cybertek.utilities.ConfigurationReader.getKey;

public class negativeLoginTest extends TestBase {


    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(getKey("driver_username"));
        loginPage.passwordInput.sendKeys(getKey("driver_password"));
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

}
