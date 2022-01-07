package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class exampleTestsPath {

    @Test
    public void test1(){
        String projectPath = System.getProperty("user.dir") + "/" + "src/test/resources/file.txt";
        System.out.println(projectPath);
    }

}
