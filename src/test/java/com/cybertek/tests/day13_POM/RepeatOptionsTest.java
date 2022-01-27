package com.cybertek.tests.day13_POM;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {



    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        BasePage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        loginPage.loginAsDriver();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());
    }


    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        BasePage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        loginPage.loginAsDriver();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        Select select = createCalendarEventsPage.repeatOptionsList();
        List<WebElement> actualOptions = select.getOptions();
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> elementsText = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(elementsText,expectedList,"Lists did not match");
    }

}
