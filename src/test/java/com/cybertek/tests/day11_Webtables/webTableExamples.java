package com.cybertek.tests.day11_Webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTableExamples {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void printTable(){
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.getText());

        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders(){

        WebElement table1 = driver.findElement(By.id("table1"));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='table1']//th"));
        System.out.println("Size: " + elements.size());

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }


    }

    @Test
    public void printTableSize(){
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }


    @Test
    public void getRow(){
        WebElement row2 = driver.findElement(By.xpath("//*[@id='table1']//tbody//tr[2]"));

        System.out.println(row2.getText());
    }


    @Test
    public void getTableData(){
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr[2]//td"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void getData(){
        WebElement website5 = driver.findElement(By.xpath("//*[@id='table1']//tbody//tr[3]//td[5]"));
        System.out.println(website5.getText());
    }

    @Test
    public void printAllByIndex(){

        for (int i = 1; i <= getRows(); i ++ ){

            for (int j = 1; j <= getColumns(); j ++ ){
                String xPath = "//*[@id='table1']//tbody/tr[" + i + "]/td[" + j + "]";
                WebElement rowData = driver.findElement(By.xpath(xPath));
                System.out.println("rowData.getText() = " + rowData.getText());
            }

        }

    }

    @Test
    public void egtElementDynamically(){

        String name = "John";
        String path = "//*[@id='table1']//td[.='" + name + "']/../td[3]";
        WebElement email = driver.findElement(By.xpath(path));
        System.out.println(email.getText());
    }


    private int getColumns(){
        List<WebElement> columns = driver.findElements(By.xpath("//*[@id='table1']//th"));
        return columns.size();
    }


    private int getRows(){
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr"));
        return rows.size();
    }

}
