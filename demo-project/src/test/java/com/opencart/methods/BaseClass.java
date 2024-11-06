package com.opencart.methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {

    WebDriver driver;

    public BaseClass(WebDriver driver){

        this.driver = driver;
    }

    public WebDriver setup(String url, String browser){

        switch (browser){

            case "google":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(url);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(url);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(url);
                break;

            case  "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.get(url);
                break;
        }

        return driver;
    }

    public  void tearDown(){

        driver.close();
        driver.quit();
    }
}
