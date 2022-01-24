package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderTwo {
    private static Properties properties;

    static {
        String path = "configurations_Two.properties";
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream(path);
            properties.load(file);
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static String getKey(String keyName){
        return properties.getProperty(keyName);
    }

}
