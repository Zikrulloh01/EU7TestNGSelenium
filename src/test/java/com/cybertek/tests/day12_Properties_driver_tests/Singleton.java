package com.cybertek.tests.day12_Properties_driver_tests;

public class Singleton {



    private Singleton(){}
    private static String str;


    public static String getStr(){

        if (str == null){
            System.out.println("Assigning value to it");
            str = "someValue";
        }
        else {
            System.out.println("It has some value returning it");
        }
        return str;
    }

}
