package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgAssertion_Demo {


    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }

    @Test
    public void test2(){
        Assert.assertEquals("title","title");
    }
    @Test
    public void test1(){
        Assert.assertEquals("titlee","titlee");
        Assert.assertEquals("hello","hello");
        System.out.println("Failed");
    }

}
