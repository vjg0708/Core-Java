package pom_object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Login {

    WebDriver driver;
    By username = By.id("input-email");
    By password = By.id("input-email");
    By loginButton = By.xpath("//button[normalize-space()='Login']");

    public POM_Login(WebDriver driver) {
        this.driver = driver;
    }

    public  void enterUserName(){

        driver.findElement(username).sendKeys("harrishvijay@gmail.com");
    }

    public void enterPassword(){

        driver.findElement(password).sendKeys("123456");
    }

    public void clickLoginButton(){

        driver.findElement(loginButton).click();
    }
}
