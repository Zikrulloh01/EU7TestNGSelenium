package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonHW {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.co.uk/");
        WebElement searcBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searcBox.sendKeys("men shoes");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
        searchButton.click();
        WebElement text = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"]/div/span"));
        WebElement searchItem = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"]/div/span[3]"));
        System.out.println(text.getText() + " " + searchItem.getText());

        Thread.sleep(3000);
        driver.quit();

    }
}
