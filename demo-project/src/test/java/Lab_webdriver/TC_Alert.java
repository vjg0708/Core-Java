package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Alert {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi?mobilelogin=1");

        driver.findElement(By.id("login1")).sendKeys("hello");

        driver.findElement(By.name("proceed")).click();

        Alert simpleAlert = driver.switchTo().alert();

        System.out.println("Alert Message is : " + simpleAlert.getText());

        simpleAlert.accept();
    }
}
