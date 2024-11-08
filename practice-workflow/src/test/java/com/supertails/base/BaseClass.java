package com.supertails.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass(WebDriver driver){

        this.driver = driver;
    }


    public WebDriver setup(String url, String browser){

        switch (browser){

            case  "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(url);
                break;

            case  "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(url);
                break;
        }

        return driver;
    }


    public void tearDown(){

        driver.close();
        driver.quit();
    }
}
