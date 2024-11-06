package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class TestNG01 {

    WebDriver driver;

    @Test(dataProvider = "dp")

    public void f(String userName, String password) throws InterruptedException {

        System.out.println("This is the test");

        driver.findElement(By.id("input-email")).sendKeys(userName);
        driver.findElement(By.id("input-password")).sendKeys(password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,370)");

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div/form/div[3]/button")).click();

    }




    @BeforeMethod

    public void beforeMethod() {

        System.out.println("This is @BeforeMethod");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.manage().window().maximize();

    }

    @AfterMethod

    public void afterMethod() throws InterruptedException {

        System.out.println("This is @AfterMethod");
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();
        driver.close();



    }


    @DataProvider

    public Object[][] dp() {

        return new Object[][] {

                new Object[] { "harrishvijay@gmail.com", "123456" }

        };

    }

    @BeforeClass

    public void beforeClass() {

        System.out.println("This is the @BeforeClass");

    }

    @AfterClass

    public void afterClass() throws InterruptedException {

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

