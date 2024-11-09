package com.odyssey.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    Properties properties;

    public PropertyConfig(String path, Properties properties) throws IOException {

        this.properties = properties;
        properties.load(new FileInputStream(path));
    }

    public String getURL(){

        return properties.getProperty("url");
    }

    public String getBrowser(){

        return properties.getProperty("browser");
    }


}
