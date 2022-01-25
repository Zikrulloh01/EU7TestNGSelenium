package com.cybertek.tests.day14_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {


        ExtentReports report;

        ExtentHtmlReporter htmlReporter;

        ExtentTest extentLogger;


        @BeforeMethod
        public void setUp(){
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

        @Test
        public void test1(){
            // give name to the current test
            extentLogger = report.createTest("TC_124 Login as Driver Test");


            extentLogger.info("Go to this url");

            extentLogger.info("Enter username and password");

            extentLogger.info("Click Login");

            extentLogger.info("Verify login");

            extentLogger.pass("TC_123 has passed");

        }

        @AfterMethod
        public void tearDown(){
            report.flush();
        }


}
