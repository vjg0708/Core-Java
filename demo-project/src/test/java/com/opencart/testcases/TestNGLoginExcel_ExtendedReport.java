package com.opencart.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.methods.BaseClass;
import com.opencart.utilities.ExcelConfig;
import com.opencart.utilities.PropertyConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import com.opencart.pageobjects.POM_LoginPageFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestNGLoginExcel_ExtendedReport {

    WebDriver driver;
    JavascriptExecutor js;


    @Test(dataProvider = "loginCredentials", dataProviderClass = ExcelConfig.class)
    public void initiateLogin(String username, String password, String browserType) throws IOException, ParserConfigurationException, SAXException, InterruptedException {

        /*Creating customised report*/
        //creating a report object
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\reports\\report.html");
        extent.attachReporter(spark);

        //adding property config to get url
        PropertyConfig config = new PropertyConfig();
        String url = config.readPropertyConfig();

        //creating driver object
        BaseClass baseClass = new BaseClass(driver);
        driver = baseClass.setup(url, browserType);

        //create a testcase object for checking the title of the page
        ExtentTest test = extent.createTest("Verify the title");
        Thread.sleep(4000);

        if (driver.getTitle().equals("Your Store")) {

            test.pass("Page Title is displayed successfully");

        } else {

            test.fail("Page Title is not displayed");
            File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ssFile, new File("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\screenshots\\ssFile1.jpg"));
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;

        POM_LoginPageFactory pomLogin = PageFactory.initElements(driver, POM_LoginPageFactory.class);
        pomLogin.enterUserName(username);
        pomLogin.enterPassword(password);

        js.executeScript("window.scrollBy(0,300)");

        pomLogin.clickLoginButton();

        //closing the resource
        extent.flush();
        baseClass.tearDown();


    }

}
