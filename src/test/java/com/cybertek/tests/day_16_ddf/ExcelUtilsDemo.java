package com.cybertek.tests.day_16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){

        // Create an object from ExcelUtils class
        // it accepts 2 arguments
        // Ar1: Location of the file
        // Ar2: sheet that we want to open

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        // how many rows in the sheet, rowCount() returns the number of rows in that sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        // HOW MANY COLUMNS in the sheet, columnCount() returns number of columns i the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        // get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        // get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println(dataList.get(2).get("firstname"));
        System.out.println(dataList.get(2).get("lastname"));
        System.out.println(dataList.get(8).get("lastname"));

        // get all data in 2d Array
        String [][] dataArray = qa3short.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));


    }
}
