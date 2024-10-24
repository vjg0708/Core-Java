package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab6_Amazon {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("harrishvijay0708@gmail.com");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("ap_password")).sendKeys("vijay#0780");
        driver.findElement(By.id("signInSubmit")).submit();

        if(driver.findElement(By.xpath("/html")).isDisplayed()){

            System.out.println("continue");
        }

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("monitors of LG brand");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_5\"]")).click();


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a")).click();

        List<String> window = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(window.get(1));
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,380)");





        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div/div/form/div/div/div/div/div[4]/div/div[37]/div[1]/span/span/span/input")));

        if(element.isDisplayed()){

            element.click();
        }

        WebElement popUpForCart = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[3]/div"));
        if(popUpForCart.isDisplayed()){

            driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/a")).click();
        }

        /*driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div/div/form/div/div/div/div/div[7]/div[3]/div[1]/span[1]/span/input")).click();
        //WebElement popUpWishList = driver.findElement(By.xpath("/html/body/div[10]/div/div"));

        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[10]/div/div/header/button")).click();*/

        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,0)");

        /*driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);*/


        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        WebElement cartItems = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]"));

        if (cartItems.isDisplayed()){

            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div[3]/div[1]/span[1]/span/span[1]/div/button[1]")).click();
        }

        WebElement emptyItems = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/div[1]/div/h2"));
        String message = emptyItems.getText();
        System.out.println(message);

        if (emptyItems.isDisplayed()){

            System.out.println("Cart is empty");
        }









    }
}
