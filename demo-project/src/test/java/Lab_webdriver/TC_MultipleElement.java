package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC_MultipleElement {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");


        //use findElements() to locate grp of similar form elements
        List<WebElement> formElement = driver.
                findElements(By.xpath("//input[@class='form-control']"));

        for(WebElement element : formElement){

            System.out.println(element.getAccessibleName());
        }
    }
}
