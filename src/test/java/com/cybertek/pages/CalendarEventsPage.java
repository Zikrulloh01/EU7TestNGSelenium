package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//div[@data-toggle='dropdown'])[2]")
    public WebElement optionsTitle;

    @FindBy(xpath = "//*[@class='input-widget']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement viewPerPage;

    @FindBy(xpath = "(//*[@class='dib'])[2]")
    public WebElement numOfPages;

    @FindBy(xpath = "(//*[@class='dib'])[3]")
    public WebElement numOfElements;

    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement nextPage;

    @FindBy(xpath = "//button/input")
    public WebElement selectAllCheckbox;

    @FindBy(xpath = "//td/input")
    public WebElement eachCheckBox;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement eventTitle;

    @FindBy(xpath = "//p/span")
    public WebElement eventDescription;

    @FindBy(xpath = "(//div[@class='control-label'])[2]")
    public WebElement eventStart;

    @FindBy(xpath = "(//div[@class='control-label'])[3]")
    public WebElement eventEnd;

    @FindBy(xpath = "(//div[@class='control-label'])[4]")
    public WebElement eventAllDay;

    @FindBy(xpath = "(//div[@class='control-label'])[5]")
    public WebElement eventOrganizer;

    @FindBy(xpath = "(//div[@class='control-label'])[6]")
    public WebElement eventCall;


    public int getPageNum(){
        String text = "";
        String numText = numOfPages.getText();
        for (int i = 0; i < numText.length(); i ++ ) {
            if (Character.isDigit(numText.charAt(i))){
                text += numText.charAt(i);
            }
        }
        return Integer.parseInt(text);
    }

    public int getNumElements(){
        String text = "";
        String numText = numOfElements.getText();
        for (int i = 0; i < numText.length(); i ++ ) {
            if (Character.isDigit(numText.charAt(i))){
                text += numText.charAt(i);
            }
        }
        return Integer.parseInt(text);
    }


    public List<WebElement> getAllTableData() throws InterruptedException {
        List<WebElement> elementList = new ArrayList<>();
        for ( int i = 0; i < getPageNum(); i ++ ){
            List<WebElement> td = Driver.getDriver().findElements(By.xpath("//*[@class='grid-body']/tr"));
            elementList.addAll(td);
            nextPage.click();
            Thread.sleep(2000);
        }
        return elementList;
    }



    public List<WebElement> getAllCheckBox() {
        List<WebElement> elementList = Driver.getDriver().findElements(By.xpath("//td/input"));
        return elementList;
    }

    public void goToCalendarEventsPage(){
        new LoginPage().logInAsStoreManager();
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        waitUntilLoaderScreenDisappear();
    }


    public void getEvent(String eventTitle){
        Driver.getDriver().findElement(By.xpath("//td[.='" + eventTitle + "']")).click();
        waitUntilLoaderScreenDisappear();
    }



}