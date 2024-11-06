package testNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pom_object_repository.POM_Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestNGAmazonv2Excel_Reports {

    WebDriver driver;
    JavascriptExecutor js;
    POM_Amazon pomAmazon;
    Properties properties;
    String username1;
    String password1;
    String projectPath;
    String url1;
    ExtentReports extent;
    ExtentSparkReporter spark;


    @Test(dataProvider = "getCredentials")
    public void startFlow(String username, String password) throws InterruptedException, IOException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*user login*/

        System.out.println("User login:");
        //sending and typing username
        pomAmazon.typeTextByXpath("//*[@id=\"ap_email\"]", username);
        pomAmazon.clickActionById("continue");

        //entering the password and signing in
        pomAmazon.typeTextById("ap_password", password);
        pomAmazon.clickActionById("signInSubmit");

        /*create test report for page  title*/
        ExtentTest pageTitle = extent.createTest("Page title");

        if (driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")){

            pageTitle.pass("Title displayed successfully");
        }
        else {


            File pageTitleSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(pageTitleSS, new File("titlepage.jpg"));
            pageTitle.fail("Title not displayed properly" + pageTitle.addScreenCaptureFromPath("titlepage.jpg"));
        }

        /*check home page*/
        ExtentTest homePage = extent.createTest("Check visibility of Home Page");


        if(pomAmazon.checkElementsDisplayedByXpath("/html")){

            homePage.pass("Page Displayed Successfully");
            System.out.println("Page is successfully displayed with source URl : " +
                    driver.getCurrentUrl());

        }
        else {

            File homePageSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(homePageSS, new File("homepage.jpg"));
            pageTitle.fail("Page not displayed properly" + pageTitle.addScreenCaptureFromPath("homepage.jpg"));
        }

        /*search product from search box*/

        System.out.println("Products search:");
        //enter product name and enter
        pomAmazon.typeTextById("twotabsearchtextbox", "monitors of LG brand");
        pomAmazon.toggleActionsById("twotabsearchtextbox", "enter");

        /*sort products based on bestseller*/

        System.out.println("Sort products:");
        //toggle the sort option
        pomAmazon.clickActionByXpath("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span");

        //click on bestsellers
        pomAmazon.clickActionByXpath("//*[@id=\"s-result-sort-select_5\"]");

        /*check for product page*/
        ExtentTest productPage = extent.createTest("Check for product page.");

        if(pomAmazon.checkElementsDisplayedByXpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']//div[@class='sg-col-inner']")){

            productPage.pass("Product Page");
            System.out.println("Product page displayed successfully");
        }
        else{

            File productPageSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(productPageSS, new File("productpage.jpg"));
            pageTitle.fail("Product Page not displayed properly" + pageTitle.addScreenCaptureFromPath("productpage.jpg"));
        }

        /*click and view product details*/

        System.out.println("Product details :");
        //navigating to product page
        pomAmazon.clickActionByXpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a");

       //creating a list to store window handle
        List<String> window = new ArrayList<>(driver.getWindowHandles());


        //switch window to product details
        driver.switchTo().window(window.get(1));

        Thread.sleep(2000);
        //scrolling below
        js.executeScript("window.scrollBy(0,380)");

        /*add product to cart*/

        System.out.println("add to cart:");
        //click add to cart button
        pomAmazon.clickActionByXpath("//input[@id='add-to-cart-button']");

        /*check for popup cart*/
        ExtentTest popupCart = extent.createTest("Check popup cart");

        //to check a popup for cart is displayed
        if (pomAmazon.checkElementsDisplayedByXpath("//div[@class='a-scroller attach-accessory-section a-scroller-vertical']")){

            popupCart.pass("Popup Page displayed");
            pomAmazon.clickActionByXpath("//a[@id='attach-close_sideSheet-link']");
        }
        else{

            File popupCarteSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(popupCarteSS, new File("popuppage.jpg"));
            pageTitle.fail("Page not displayed properly" + pageTitle.addScreenCaptureFromPath("popuppage.jpg"));
        }

        //scroll to top of the page
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,0)");

        /*visit cart and delete products*/

        System.out.println("delete items in cart");
        //navigate to product cart
        pomAmazon.clickActionByXpath("//a[@id='nav-cart']");

        /*check cart visibility*/
        ExtentTest openCart = extent.createTest("Check cart visibility");

        //check products are displayed in cart
        if (pomAmazon.checkElementsDisplayedByXpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]")){

           openCart.pass("cart is visible");
            //delete item from cart
            pomAmazon.clickActionByXpath("//button[@aria-label='Decrease quantity by one']");

            System.out.println("items deleted successfully");
        }
        else {

            File carteSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(carteSS, new File("cart.jpg"));
            pageTitle.fail("Page not displayed properly" + pageTitle.addScreenCaptureFromPath("cart.jpg"));
        }




    }

    @BeforeMethod
    public void setUp() throws IOException {


        /*setup driver to open amazon*/
        System.out.println("Driver initialization and page loading");
        driver.get(url1);
        driver.manage().window().maximize();


        System.out.println("Driver session started..");

    }

    @AfterMethod
    public void tearDown() {


        /*logout*/
        pomAmazon.toggleActionsByXpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]",
                "hover");
        pomAmazon.checkElementsDisplayedByXpath("//span[normalize-space()='Sign Out']");

        System.out.println("logout successful");

        extent.flush();
        driver.close();
    }

    @BeforeClass
    public void beforeClass() throws IOException {

        /*create report object*/
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("Amazon.html");
        extent.attachReporter(spark);


        projectPath = System.getProperty("user.dir");

        //getting credentials and URL from properties
        properties = new Properties();
        InputStream input = Files.newInputStream(Paths.get(projectPath + "\\amazonLogin.properties"));

        properties.load(input);

        url1 = properties.getProperty("url");
        /*username1 = properties.getProperty("username");
        password1 = properties.getProperty("password");*/


        /*setting up chrome driver*/

        System.out.println("setting up the driver..");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /*setting up POM object */

        System.out.println("creating POM object..");
        pomAmazon = new POM_Amazon(driver);

        FileInputStream excelFile = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\Amazon.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheet("Login");

        int noORows = sheet.getPhysicalNumberOfRows();
        System.out.println("Rows : " + noORows);

        username1 = sheet.getRow(0).getCell(0).getStringCellValue();
        password1 = sheet.getRow(0).getCell(1).getStringCellValue();

        /*storing username and password*/
        pomAmazon.setUsername(username1);
        pomAmazon.setPassword(password1);



        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void afterClass() {

        driver.quit();

        System.out.println("Driver session closed");
    }

    @DataProvider
    public Object[][] getCredentials() {

        return new Object[][]{

                new Object[]{pomAmazon.getUsername(), pomAmazon.getPassword()}
        };

    }
}
