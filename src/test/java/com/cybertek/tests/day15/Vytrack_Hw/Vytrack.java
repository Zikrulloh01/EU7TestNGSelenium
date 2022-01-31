package com.cybertek.tests.day15.Vytrack_Hw;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Vytrack extends TestBase {


    @Test
    public void test1(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.optionsTitle.isDisplayed());
        System.out.println("calendarEventsPage.optionsTitle.getText() = " + calendarEventsPage.optionsTitle.getText());
    }

    @Test
    public void test2(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        System.out.println("new CalendarEventsPage().pageNumber.getAttribute(\"value\") = " + new CalendarEventsPage().pageNumber.getAttribute("value"));
    }
    @Test
    public void test3(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        Assert.assertEquals(new CalendarEventsPage().viewPerPage.getText(), "25");
        System.out.println("new CalendarEventsPage().viewPerPage.getText() = " + new CalendarEventsPage().viewPerPage.getText());

    }


    @Test
    public void test4() throws InterruptedException {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        int length = calendarEventsPage.getAllTableData().size();
        Assert.assertEquals(length, calendarEventsPage.getNumElements(), "Elements failed");
        System.out.println("length = " + length);
        System.out.println("new CalendarEventsPage().getNumElements() = " + calendarEventsPage.getNumElements());
    }


    @Test
    public void test5(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        calendarEventsPage.selectAllCheckbox.click();
        List<WebElement> allCheckBox = calendarEventsPage.getAllCheckBox();
        for (WebElement checkBox : allCheckBox) {
            Assert.assertTrue(checkBox.isSelected());
        }
    }

    @Test
    public void test6(){
        String expectedTitle = "Testers meeting";
        String expectedDescription = "This is a a weekly testers meeting";
        String expectedStartDate = "Nov 27, 2019, 9:30 AM";
        String expectedEndDate = "Nov 27, 2019, 10:30 AM";
        String expectedAllDayEvent = "No";
        String expectedOrganizer = "Stephan Haley";
        String expectedGuest = "Tom Smith";
        String expectedRecurrence = "Weekly every 1 week on Wednesday";
        String expectedCall = "No";
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.goToCalendarEventsPage();
        calendarEventsPage.getEvent("Testers meeting");
        Assert.assertEquals(calendarEventsPage.eventTitle.getText(), expectedTitle, "Title Failed");
        Assert.assertEquals(calendarEventsPage.eventDescription.getText(), expectedDescription, "Description Failed");
        Assert.assertEquals(calendarEventsPage.eventStart.getText(), expectedStartDate, "Start date Failed");
        Assert.assertEquals(calendarEventsPage.eventEnd.getText(),expectedEndDate, "End date Failed");
        Assert.assertEquals(calendarEventsPage.eventAllDay.getText(), expectedAllDayEvent, "all Day Failed");
        Assert.assertEquals(calendarEventsPage.eventOrganizer.getText(), expectedOrganizer, "Organizer Failed");
        Assert.assertEquals(calendarEventsPage.eventCall.getText(), expectedCall, "Call Failed");

    }


}
