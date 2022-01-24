package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReaderTwo;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import static com.cybertek.utilities.Driver.*;




public class TestBase2 {


    protected WebDriver driver;
    protected WebDriverWait wait;
    private Actions actions;


    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        driver.get(ConfigurationReaderTwo.getKey("url"));
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        closeDriver();
    }

}
