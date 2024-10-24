package Lab_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab6_Amazon {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();

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




        /*driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a")).click();



        WebElement description = driver.findElement(By.xpath("//*[@id=\"productTitle\"]"));
        if (description.isDisplayed()){

            System.out.println("Product Description : "+description.getText());
        }


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");*/

      /*  driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div/div/form/div/div/div/div/div[7]/div[3]/div[1]/span[1]/span/input")).submit();

        WebElement wishList = driver.findElement(By.xpath("//*[@id=\"huc-atwl-inner\"]"));

        if(wishList.isDisplayed()){

            driver.findElement(By.xpath("//*[@id=\"a-popover-8\"]/div/header/button")).click();
        }*/





        //driver.findElement(By.xpath("//*[@id=\"5c0e96a4-ed07-49ac-8574-e613b1fa1446\"]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[4]/div/div/div[2]/span/div")).click();

    }
}
