package pom_object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Amazon {

    WebDriver driver;
    By username = By.id("//*[@id=\"ap_email\"]");

    //continue click
    public void clickActionById(String click){

        driver.findElement(By.id(click)).click();
    }

    By password = By.id("ap_password");
    By signIn = By.id("signInSubmit");

    public void





}
