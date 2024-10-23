package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login {

    public static void main(String[] args) {

        /*loading and creating a Chrome web driver and
        * setting up a login page*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        /*locating the elements*/

        driver.findElement(By.linkText("My Account")).click();
//        driver.findElement(By.linkText("Login")).click();
    }
}
