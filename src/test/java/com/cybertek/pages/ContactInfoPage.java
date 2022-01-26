package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{

    @FindBy(className = "user-name")
    public WebElement fullName;

    @FindBy(className = "phone")
    public WebElement phoneNumber;

    @FindBy(className = "email")
    public WebElement email;


}
