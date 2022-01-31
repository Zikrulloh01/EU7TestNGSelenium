package com.cybertek.tests.day_16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {



    @DataProvider
    public Object [][] testData(){

        String [] [] data ={
                {"Person of Interest","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"Abdulhamidkhan","8"},
                {"Friends","7"},
                {"BBC news","10"},
                {"WestWorld","10"},
                {"Gotam","9"}
        };





        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rating){
        System.out.println("Tv show: "  + tvShow + "has rating of: " + rating);
    }


}
