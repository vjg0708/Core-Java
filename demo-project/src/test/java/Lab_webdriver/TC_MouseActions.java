package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TC_MouseActions {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");

        driver.findElement(By.xpath("/html/body/div[10]/div[3]/div/div[1]/div[2]/ul/li[1]/a/span[2]")).click();

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.linkText("Sunglasses"))).click().perform();
    }
}
