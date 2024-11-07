package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {


    public String readPropertyConfig() throws IOException {

        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\src\\test\\java\\com\\opencart\\testdata\\login.properties");

        properties.load(input);

        return properties.getProperty("url");
    }
}
