package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNGAmazon {

    WebDriver driver;
    JavascriptExecutor js;

    @Test(dataProvider = "loginCredentials")
    public void testApp(String userId, String password) throws InterruptedException {
        System.out.println("This is the test");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));

        if(element.isDisplayed()){

            element.click();
        }

        WebElement popUpForCart = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[3]/div"));
        if(popUpForCart.isDisplayed()){

            driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/a")).click();
        }

        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,0)");

        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        WebElement cartItems = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]"));

        if (cartItems.isDisplayed()){

            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div[3]/div[1]/span[1]/span/span[1]/div/button[1]")).click();
        }

        WebElement emptyItems = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/div[1]/div/h2"));
        String message = emptyItems.getText();
        System.out.println(message);




    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is @BeforeMethod");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is @AfterMethod");

        WebElement logOut = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(logOut).perform();

        driver.findElement(By.xpath("//span[normalize-space()='Sign Out']")).click();
        driver.close();
    }


    @DataProvider
    public Object[][] loginCredentials() {
        return new Object[][] {
                new Object[] { "harrishvijay0708@gmail.com", "vijay#0780" }
        };
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is the @BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is the @AfterClass");

        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is the @BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is the @AfterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is the @BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is the @AfterSuite");
    }

}
