package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Lab5_Registration {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demo.opencart.com/en-gb?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,400)");
        /*email*/
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("harrish@gmail.com");

        /*String mailId = email.getText();
        Pattern checkMail = Pattern.compile("^[a-zA-Z._0-9]+@[a-zA-Z0-9]+//.[a-zA-Z.]{2,6}$");*/

        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)");
        /*pasword*/
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123456");


        /*newsletter*/
        WebElement newsletter = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        newsletter.click();

        /*privacy policy*/
        WebElement policy = driver.findElement(By.xpath("//input[@name='agree']"));
        policy.click();

        driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();

        if(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed()){

            System.out.println("Registration Successful");
        }
        else{
            System.out.println("Registration failed");
        }

        driver.close();
    }
}
