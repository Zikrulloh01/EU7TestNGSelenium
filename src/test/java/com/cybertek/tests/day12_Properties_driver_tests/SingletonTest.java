package com.cybertek.tests.day12_Properties_driver_tests;

import com.cybertek.utilities.Driver;
import static com.cybertek.utilities.ConfigurationReader.*;
import org.openqa.selenium.WebDriver;
import static com.cybertek.utilities.Driver.*;
import org.testng.annotations.Test;

public class SingletonTest {


    //@Test
    public void test1(){
        String s1 = Singleton.getStr();
        String s2 = Singleton.getStr();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }



    @Test
    public void test2() throws InterruptedException {

        //WebDriver driver = Driver.get();
        Thread.sleep(2000);
        getDriver().get(getKey("url"));
        closeDriver();

    }

    @Test
    public void test3(){
//        WebDriver driver = Driver.get();
        getDriver().get("https://amazon.com");
    }

}
