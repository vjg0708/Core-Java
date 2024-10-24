package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TC_SelectDropDown {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");


        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        //gets a selected list of dropdown options
        Select select = new Select(driver.findElement(By.id("input-sort")));

        select.selectByIndex(5);

        select.selectByVisibleText("Rating (Lowest)");

        List<WebElement> count = select.getOptions();

        for(int i=0;i< count.size();i++){

            System.out.println(count.get(i).getText());
        }
    }
}
