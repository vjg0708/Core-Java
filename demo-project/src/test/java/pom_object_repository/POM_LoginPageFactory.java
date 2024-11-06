package pom_object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_LoginPageFactory {

    WebDriver driver;
    @FindBy(id = "input-email")
    WebElement username;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
   /* By username = By.id("input-email");
    By password = By.id("input-email");
    By loginButton = By.xpath("//button[normalize-space()='Login']");*/



    public  void enterUserName(String name){

        username.sendKeys(name);
    }

    public void enterPassword(String pwd){

        password.sendKeys(pwd);
    }

    public void clickLoginButton(){

        loginButton.click();
    }
}
