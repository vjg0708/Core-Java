package com.supertails.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.supertails.base.BaseClass;
import com.supertails.objectRepository.SupertailsPom;
import com.supertails.utilities.PropertyConfig;
import com.supertails.utilities.ReportGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainTest {

    WebDriver driver;
    Properties property;
    BaseClass driverConfig;
    PropertyConfig propertyConfig;
    String url;
    String browser;
    JavascriptExecutor executor;
    ExtentReports reportInstance;
    ExtentSparkReporter buildReport;
    SupertailsPom pomRepo;
    ReportGenerator generateReport;

    @BeforeClass
    public void initiate() throws IOException {

        System.out.println("Beginning of process...");

        driverConfig = new BaseClass(driver);
        property = new Properties();
        propertyConfig = new PropertyConfig("C:\\Users\\harrish.vijay\\eclipse-workspace\\practice-workflow\\src\\test\\java\\com\\supertails\\resources\\supertail.properties",
                property);

        url = propertyConfig.getURL();
        browser = propertyConfig.getBrowser();

        reportInstance = new ExtentReports();
        buildReport = new ExtentSparkReporter("C:\\Users\\harrish.vijay\\eclipse-workspace\\practice-workflow\\src\\test\\java\\com\\supertails\\resources\\reports\\report.html");

        driver = driverConfig.setup(url,browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        executor = (JavascriptExecutor) driver;
        pomRepo = new SupertailsPom(driver);

        generateReport = new ReportGenerator(reportInstance,buildReport);

    }


    @Test(priority = 1)
    public void addToCart() throws InterruptedException {

        System.out.println("Test Method 1");

        pomRepo.inputDataById("mainfrm", "dog food");
        pomRepo.toggleActionsById("mainfrm","enter");

        Thread.sleep(3000);
        executor.executeScript("window.scrollBy(0,400)");
        pomRepo.clickElementByXpath("/html/body/div[2]/main/div/div/div/div[1]/div[2]/div[1]/div/div[1]/div[3]/div[2]/ul/li[1]/a/div[2]/b/div[2]/img");

        Thread.sleep(3000);
        executor.executeScript("window.scrollBy(0,300)");
        pomRepo.clickElementByXpath("//button[@class = 'atc_custom center_atc show_atc']");

        pomRepo.clickElementById("HeaderCartTrigger");

    }

    @Test(priority = 2)
    public void removeCart() throws InterruptedException, IOException {

        System.out.println("Test method 2");

        ExtentTest checkCartItem = generateReport.createTestCase("Cart Visibility");
        Thread.sleep(3000);
        if (pomRepo.checkVisibilityByXpath("//div[@class = 'new_cart_top']")){

           generateReport.passTestCase(checkCartItem, "Cart item is visible");
        }
        else {

            generateReport.failTestCase(checkCartItem, "Item is not visible",
                                        driver, "checkcart");
        }


        pomRepo.clickElementById("minusqty");


        ExtentTest emptyCart = generateReport.createTestCase("Cart is empty");
        Thread.sleep(3000);
        if (pomRepo.checkVisibilityByXpath("/html/body/div[2]/main/div/div[3]/header/div/p[1]/text()")){

            generateReport.passTestCase(emptyCart, "Cart is empty");
        }

        else {

            generateReport.failTestCase(emptyCart,"item not removed",
                    driver,"deletecart");
        }
    }


    @AfterClass
    public void closeResources(){

        reportInstance.flush();
        driverConfig.tearDown();
        property.clear();
        System.out.println("End of Process...");
    }
}
