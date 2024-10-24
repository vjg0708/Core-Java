package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_AlertTypes {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/alert");
        driver.manage().window().maximize();

        //sets timeout as 10sec to wait for whole web driver session, inorder to find and identify an element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //simplealert
        driver.findElement(By.id("accept")).click();
        Alert simpleAlert = driver.switchTo().alert();

            System.out.println("Simple Alert : " + simpleAlert.getText());
            simpleAlert.accept();

        //confirmalert
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();

            System.out.println("Confirm Alert : "+confirmAlert.getText());
            confirmAlert.accept();

        //promptalert
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();

        System.out.println("Prompt Alert : "+ promptAlert.getText());
        promptAlert.sendKeys("Okay");
        promptAlert.dismiss();



        //modernalert
//        Thread.sleep(2000);
        driver.findElement(By.id("modern")).click();
        WebElement modernAlert = driver.findElement(By.xpath("//div[@class='modal-background']"));

//        Thread.sleep(2000);
        if(modernAlert.isDisplayed()){

            driver.findElement(By.xpath("//div/button[@aria-label='close']")).click();
            System.out.println("Displayed properly");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('search testing methods')");

    }
}
