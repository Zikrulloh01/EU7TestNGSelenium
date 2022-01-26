package com.cybertek.tests;

import static com.cybertek.utilities.Driver.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private Actions actions;


    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);


        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getKey("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        driver.get(ConfigurationReader.getKey("url"));
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, InterruptedException {

        if (result.getStatus()==ITestResult.FAILURE){
            // record the name of the failed test
            extentLogger.fail(result.getName());

            // take a screenshot of it and return location of the screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());

            //add screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            extentLogger.fail(result.getThrowable());
        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){
        // this is when test report is created
        report.flush();
    }

}
