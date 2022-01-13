package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cybertek.utilities.ConfigurationReader.getKey;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(tagName = "h2")
    public WebElement loginTitle;

    @FindBy(css = ".alert.alert-error>div")
    public WebElement errorMessage;


    public void logIn(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void logInAsStoreManager(){
        String username = getKey("storeManager_Username");
        String password = getKey("storeManager_Password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
