package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TC_WindowHandle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/windows");

        System.out.println("Window Handle : "  + driver.getWindowHandle());

        driver.findElement(By.id("multi")).click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String i:windowHandles){

            System.out.println("Window Handle: "+i);
        }

        driver.switchTo().window(windowHandles.get(2));
        System.out.println("Page URL : " + driver.getCurrentUrl());
    }
}
