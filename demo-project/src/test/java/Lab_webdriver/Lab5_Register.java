package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab5_Register {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        if(driver.getTitle().equals("Register Account")){

            System.out.println("Continue");
        }
        else{

            System.out.println("Not Displayed");
        }

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(320,document.body.scrollHeight)");
        Thread.sleep(3000);


        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Thread.sleep(2000);

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println("Alert Message : "+ alertMessage);

        alert.accept();*/



        System.out.println("Warning : " + driver.findElement(By.id("alert")).isDisplayed());

        Thread.sleep(500);

        System.out.println("Alert Message : " + driver.findElement(By.xpath("//div[@id='alert']/dirv")).getText());


       // Alert alert = driver.switchTo().alert();
//        System.out.println("Alert text : " + alert.getText());

        /*if(driver.switchTo()
                .alert()
                .getText()
                .equalsIgnoreCase("Warning:You must agree to privacy policy!")){

            System.out.println("Alert displayed successfully");
        }
        else{

            System.out.println("Alert message timeout");
        }*/


    }
}
