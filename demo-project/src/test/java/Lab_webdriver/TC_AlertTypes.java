package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_AlertTypes {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/alert");
        driver.manage().window().maximize();


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
        Thread.sleep(2000);
        driver.findElement(By.id("modern")).click();
        WebElement modernAlert = driver.findElement(By.xpath("//div[@class='modal-background']"));

        Thread.sleep(2000);
        if(modernAlert.isDisplayed()){

            driver.findElement(By.xpath("//div/button[@aria-label='close']")).click();
            System.out.println("Displayed properly");
        }
    }
}
