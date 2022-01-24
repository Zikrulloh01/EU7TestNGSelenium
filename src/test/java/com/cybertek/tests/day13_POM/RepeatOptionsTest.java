package com.cybertek.tests.day13_POM;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    BasePage dashboardPage = new DashboardPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

    @Test
    public void test1(){
        loginPage.loginAsDriver();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());
    }

}
