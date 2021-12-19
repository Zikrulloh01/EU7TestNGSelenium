package com.cybertek.tests.day7_testNG;

import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void test1(){
        System.out.println("My first test case");
        test2();
    }

    @Test
    public void test2(){
        System.out.println("Second test Case");
    }




}