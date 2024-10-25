package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom_object_repository.POM_Login;

import java.util.concurrent.TimeUnit;

public class TC_Login {



    public static void main(String[] args) {

        /*loading and creating a Chrome web driver and
         * setting up a login page*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        POM_Login pomLogin = new POM_Login(driver);

        pomLogin.enterUserName();
        pomLogin.enterPassword();

        js.executeScript("window.scrollBy(0,300)");

        pomLogin.clickLoginButton();

        driver.close();

    }


}
