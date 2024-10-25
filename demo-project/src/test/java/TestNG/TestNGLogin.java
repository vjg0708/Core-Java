package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pom_object_repository.POM_Login;

import java.util.concurrent.TimeUnit;

public class TestNGLogin {

    WebDriver driver;
    JavascriptExecutor js;

    @Test
    public void initiateLogin() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;

        POM_Login pomLogin = new POM_Login(driver);

        pomLogin.enterUserName();
        pomLogin.enterPassword();

        js.executeScript("window.scrollBy(0,300)");

        pomLogin.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    @BeforeMethod
    public void setUp() {

        driver.get("https://demo.opencart.com/en-gb?route=account/login");
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("before class");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
