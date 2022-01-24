package com.cybertek.pages.adidasPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePageForAdidas{

    @FindBy(linkText = "Phones")
    public WebElement phoneCategory;

    @FindBy(linkText = "Laptops")
    public WebElement laptopsCategory;

    @FindBy(linkText = "Monitors")
    public WebElement monitorsCategory;

}
