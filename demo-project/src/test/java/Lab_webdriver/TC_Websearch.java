package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Websearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.co.in/");
        System.out.println("The title of the page: " + driver.getTitle());

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Testing Methods");
        element.submit();

        System.out.println("The title of the page: " + driver.getTitle());


        Thread.sleep(3000);
        driver.navigate().to("https://www.yahoo.com/");
        System.out.println("The title of the page: " + driver.getTitle());

        Thread.sleep(3000);
        driver.navigate().back();
        System.out.println("The title of the page: " + driver.getTitle());

        Thread.sleep(3000);
        driver.navigate().forward();
        System.out.println("The title of the page: " + driver.getTitle());

        /*System.out.println("URL pagesource : ");
        System.out.println(driver.getPageSource());*/

        System.out.println("Page source is : " +
                driver.getPageSource().contains("yahoo"));

    }
}
