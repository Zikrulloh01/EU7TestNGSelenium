package com.cybertek.tests.day13_POM;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cybertek.utilities.ConfigurationReader.getKey;

public class positiveLoginTest extends TestBase {


    @Test
    public void loginAsDriver(){
        LoginPage loginPage = new LoginPage();
        String username = getKey("driver_username");
        String password = getKey("driver_password");
        loginPage.logIn(username,password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }


    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();
        loginPage.logInAsStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

}
