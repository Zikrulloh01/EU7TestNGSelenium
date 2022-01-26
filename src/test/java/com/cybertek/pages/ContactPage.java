package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{


    public WebElement getEmail(String email){
        return Driver.getDriver().findElement(By.xpath("//td[text()='" + email + "'][@data-column-label='Email']"));
    }

}
