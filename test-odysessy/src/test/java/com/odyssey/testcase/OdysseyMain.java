package com.odyssey.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.odyssey.basemethods.BaseClass;
import com.odyssey.pageobjects.ObjectPOM;
import com.odyssey.utilities.ExcelDataSource;
import com.odyssey.utilities.PropertyConfig;
import com.odyssey.utilities.ReportGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OdysseyMain {

    WebDriver driver;
    JavascriptExecutor js;
    ObjectPOM pomObject;
    BaseClass setDriver;
    PropertyConfig propertyConfig;
    ExtentReports reportInstance;
    ExtentSparkReporter loadReport;
    ReportGenerator generateReport;
    Properties properties;
    String url;
    String browser;

    @BeforeClass
    public void initiate() throws IOException {

        properties = new Properties();
        propertyConfig = new PropertyConfig("C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\resources\\odyssey.properties",properties);

        url = propertyConfig.getURL();
        browser = propertyConfig.getBrowser();

        setDriver = new BaseClass(driver);
        driver = setDriver.setup(url,browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;

        pomObject = new ObjectPOM(driver);

        reportInstance = new ExtentReports();
        loadReport = new ExtentSparkReporter("C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\testreports\\reports.html");

        generateReport = new ReportGenerator(reportInstance,
                loadReport);
    }

    @Test(priority = 3)
    public void register() throws IOException, InterruptedException {

        pomObject.clickElementByXpath("//a[@aria-label='My account']");
        js.executeScript("window.scrollBy(0,100)");

        Thread.sleep(2000);
        pomObject.clickElementByXpath("//button[normalize-space()='Create your account']");

        pomObject.inputDataById("register-customer[first_name]",
                "Harrish");
        pomObject.inputDataById("register-customer[last_name]", "Vijay G");
        pomObject.inputDataById("register-customer[email]", "harrishvijay.gk8720@gmail.com");
        pomObject.inputDataById("register-customer[password]", "vijay#0708");

        pomObject.clickElementByXpath("//button[normalize-space()='Create my account']");

        pomObject.clickElementByXpath("//a[@aria-label='My account']");

        ExtentTest register = generateReport.createTestCase("Verify Registration");
        if(pomObject.checkVisibilityByLinkText("My orders")){

            generateReport.passTestCase("Account registered Successfully",register);

        }
        else {
            generateReport.failTestCase("Account registration failed",
                    register,driver,
                    "C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\testreports\\register.jpg");
        }


    }

    @Test(priority = 2)
    public void logout() throws InterruptedException, IOException {

        Thread.sleep(2000);

        pomObject.clickElementByXpath("//a[@aria-label='My account']");
        pomObject.clickElementByLinkText("Logout");

        ExtentTest logout = generateReport.createTestCase("logout");

        if(pomObject.checkVisibilityByXpath("//h2[normalize-space()='Login to my account']")){

            generateReport.passTestCase("logout successful",logout);
        }
        else {

            generateReport.failTestCase("Logout failed",logout,
                    driver,"C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\testreports\\logout.jpg");
        }
        Thread.sleep(2000);

    }

    @Test(dataProvider = "credentials", dataProviderClass = ExcelDataSource.class, priority = 1)
    public void login(String username, String password) throws InterruptedException, IOException {

        Thread.sleep(2000);

        pomObject.clickElementByXpath("//a[@aria-label='My account']");
        pomObject.inputDataById("login-customer[email]",username);
        pomObject.inputDataById("login-customer[password]",password);

        pomObject.clickElementByXpath("//button[normalize-space()='Login']");

        ExtentTest login = generateReport.createTestCase("Verify login");
        if(pomObject.checkVisibilityByLinkText("My orders")){

            generateReport.passTestCase("Login Successfully",login);

        }
        else {
            generateReport.failTestCase("login failed",
                    login,driver,
                    "C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\testreports\\login.jpg");
        }

        
    }


    @AfterClass
    public void closeResources(){

        reportInstance.flush();
        setDriver.tearDown();
    }
}
