package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab5_LastName {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        WebElement lastname = driver.findElement(By.name("lastname"));
        String typeLn = "dbhdsjjjjjjfdjddddddddddddddmsndzkalalcndassdsaahhhhhhhhhhhhhhhhhh";

        lastname.sendKeys(typeLn);

        lastname.submit();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(320,document.body.scrollHeight)");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        Thread.sleep(700);

        String message = driver.findElement(By.id("error-lastname")).getText();

        if(!(message.isEmpty())){

            System.out.println("Enter a valid last name");
        }

        System.out.println(message);
    }
}
