package com.supertails.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    Properties property;

    public PropertyConfig(String fileSource, Properties property) throws IOException {

        this.property = property;
        property.load(new FileInputStream(fileSource));
    }

    public String getURL(){

        return property.getProperty("url");
    }

    public String getBrowser(){

        return property.getProperty("browser");
    }
}
