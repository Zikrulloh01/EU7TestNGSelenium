package com.cybertek.tests.reviews.Announcement_Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class PhoneShopping {
    WebDriver driver;
    int expectedBill = 0;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void navigateTo(String str){
        driver.findElement(By.linkText(str)).click();
    }

    public void addProduct(String str){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        navigateTo(str);
        navigateTo("Add to cart");
        expectedBill += billCalculator();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.navigate().to("https://www.demoblaze.com/index.html");
    }

    public int billCalculator(){
        String priceText = driver.findElement(By.xpath("//*[@id='tbodyid']/h3")).getText();
        String priceInString = "";
        for (int i = 0; i < priceText.length(); i ++ ){
            if (Character.isDigit(priceText.charAt(i))){
                priceInString += priceText.charAt(i);
            }
        }
        return  Integer.parseInt(priceInString);
    }

    public void removeItem(String itemName){
        int itemPrice = Integer.parseInt(driver.findElement(By.xpath("(//*[.='" + itemName +"'])/../td[3]")).getText());
        expectedBill -= itemPrice;
        WebElement deleteLink = driver.findElement(By.xpath("(//*[.='" + itemName + "'])/../td[4]/a"));
        deleteLink.click();
    }

    public void fillOutForm(String name, String country, String city, String cardNumber, String month, String year){
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(cardNumber);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
    }
    public int getActualPrice(){
        String cheque = driver.findElement(By.xpath("//p[@style='display: block;']")).getText();
        String price = cheque.substring(cheque.indexOf("t:") + 2, cheque.indexOf("USD"));
        return Integer.parseInt(price.trim());
    }
    public void verifyPrice(int expectedPrice, int actualPrice){
        Assert.assertEquals(actualPrice,expectedPrice, "Price has failed to verify");
    }

    @Test
    public void shopPhone() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.demoblaze.com/index.html");
        navigateTo("Laptops");
        Thread.sleep(1000);
        addProduct("Sony vaio i5");
        navigateTo("Laptops");
        Thread.sleep(1000);
        addProduct("Dell i7 8gb");
        navigateTo("Laptops");
        addProduct("MacBook air");
        navigateTo("Cart");
        removeItem("MacBook air");
        removeItem("Dell i7 8gb");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='col-lg-1']/button")).click();
        fillOutForm("Zikrulloh Islomov", "UK", "London", "1234 1234 1234 1234", "January", "2021");
        driver.findElement(By.xpath("//*[@onclick='purchaseOrder()']")).click();
        verifyPrice(expectedBill,getActualPrice());
    }
}
