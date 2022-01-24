package com.cybertek.pages.adidasPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePageForAdidas{

    @FindBy(xpath = "//*[@onclick='purchaseOrder()']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//*[@class='col-lg-1']/button")
    public WebElement placeOrderButton;


    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement card;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;


    public void fillForm(){
        Faker faker = new Faker();

        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys("" + faker.number().numberBetween(1,12));
        year.sendKeys("" + faker.number().numberBetween(2020,2025));
    }



}
