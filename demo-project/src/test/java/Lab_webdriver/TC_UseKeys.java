package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UseKeys {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        driver.findElement(By.name("firstname")).sendKeys("Harrish");
        //use key chords to make control to next field using tab
        driver.findElement(By.name("firstname")).sendKeys(Keys.TAB);
        driver.findElement(By.name("lastname")).sendKeys(Keys.NUMPAD7);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(320,document.body.scrollHeight)");

        Thread.sleep(2000);
        WebElement subcribe = driver.findElement(By.id("input-newsletter"));

        subcribe.click();

        if(subcribe.isSelected()){

            System.out.println("True");
        }
        else{

            System.out.println("False");
        }


    }
}
