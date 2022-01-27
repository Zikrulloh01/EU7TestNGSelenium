package com.cybertek.tests.day13_POM;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.loginAsDriver();
        Assert.assertEquals(basePage.getPageSubTitle(), "Quick Launchpad", "Subtitles did not match");
        basePage.navigateToModule("Activities", "Calendar Events");
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Second title did not match");
    }


}
