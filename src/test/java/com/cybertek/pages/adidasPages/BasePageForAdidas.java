package com.cybertek.pages.adidasPages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePageForAdidas {

    int expectedBill = 0;

    public BasePageForAdidas(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public void navigateTo(String str){
        Driver.getDriver().findElement(By.linkText(str)).click();
    }

    public void addProduct(String str){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        navigateTo(str);
        navigateTo("Add to cart");
        expectedBill += billCalculator();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        Driver.getDriver().navigate().to("https://www.demoblaze.com/index.html");
    }

    public int billCalculator(){
        String priceText = Driver.getDriver().findElement(By.xpath("//*[@id='tbodyid']/h3")).getText();
        String priceInString = "";
        for (int i = 0; i < priceText.length(); i ++ ){
            if (Character.isDigit(priceText.charAt(i))){
                priceInString += priceText.charAt(i);
            }
        }
        return  Integer.parseInt(priceInString);
    }

    public void removeItem(String itemName){
        int itemPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath("(//*[.='" + itemName +"'])/../td[3]")).getText());
        expectedBill -= itemPrice;
        WebElement deleteLink = Driver.getDriver().findElement(By.xpath("(//*[.='" + itemName + "'])/../td[4]/a"));
        deleteLink.click();
    }


    public int getActualPrice(){
        String cheque = Driver.getDriver().findElement(By.xpath("//p[@style='display: block;']")).getText();
        String price = cheque.substring(cheque.indexOf("t:") + 2, cheque.indexOf("USD"));
        return Integer.parseInt(price.trim());
    }


    public void verifyPrice(int expectedPrice, int actualPrice){
        Assert.assertEquals(actualPrice,expectedPrice, "Price has failed to verify");
    }

    public int getExpectedBill(){
        return expectedBill;
    }

}
